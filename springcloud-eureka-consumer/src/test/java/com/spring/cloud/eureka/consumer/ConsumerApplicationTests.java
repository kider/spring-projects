package com.spring.cloud.eureka.consumer;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerApplicationTests {


	private final static String HOST_NAME ="localhost";

	private final static Integer[] PORTS = new Integer[]{2101,2102};

	private final static String[] URI = new String[]{"/consumer","/loadBalancedConsumer","/feignConsumer"};

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(100);

		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		HttpClient httpClient = httpClientBuilder.build();

		Runnable taskA = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[0],URI[0],httpClient);
		};

		Runnable taskB = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[0],URI[1],httpClient);
		};

		Runnable taskC = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[0],URI[2],httpClient);
		};

		Runnable taskD = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[1],URI[0],httpClient);
		};

		Runnable taskE = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[1],URI[1],httpClient);
		};

		Runnable taskF = ()->{
			exeHttpGetJob(HOST_NAME,PORTS[1],URI[2],httpClient);
		};

		int j = 0;
		while(j<=20){
			executorService.submit(taskA);
			executorService.submit(taskB);
			executorService.submit(taskC);
			executorService.submit(taskD);
			executorService.submit(taskE);
			executorService.submit(taskF);
			j++;
		}

		executorService.shutdown();
	}


	private static void exeHttpGetJob(String hostName,int port,String uri,HttpClient httpClient){

		HttpHost httpHost = new HttpHost(hostName,port);

		HttpGet httpGet = new HttpGet(uri);

		HttpClientContext httpClientContext = HttpClientContext.create();

		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpHost,httpGet,httpClientContext);
		} catch (IOException e) {
			e.printStackTrace();
		}

		InputStream inputStream = null;
		try {
			inputStream = httpResponse.getEntity().getContent();
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] buffer = new byte[6];

		byte[] result = new byte[512];

		int i = 0;

		try {
			while (-1!=(inputStream.read(buffer,0,buffer.length))){

//				System.out.println("this buffer:"+new String(buffer));

				for(byte b : buffer){
					result[i] = b;
					i++;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("this response:"+new String(result));

	}



}
