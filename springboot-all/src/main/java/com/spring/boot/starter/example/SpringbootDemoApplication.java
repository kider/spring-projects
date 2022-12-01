package com.spring.boot.starter.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@EnableCaching
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootDemoApplication.class);
        springApplication.run(args);
    }

    //自定义 嵌入式web容器配置
	/*@Bean
	public static EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				if (container instanceof TomcatEmbeddedServletContainerFactory) {

					TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);

					factory.addContextCustomizers(new TomcatContextCustomizer() {
						@Override
						public void customize(Context context) {

							context.setPath("/spring-boot");
						}
					});

					factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
						@Override
						public void customize(Connector connector) {
							connector.setPort(8888);
							connector.setProtocol(Http11Nio2Protocol.class.getName());
						}
					});
				}

			}
		};
	};*/
}
