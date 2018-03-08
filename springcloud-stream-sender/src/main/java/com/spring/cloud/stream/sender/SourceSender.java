package com.spring.cloud.stream.sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableBinding(Source.class)
@Component
public class SourceSender {

    @Autowired
    private Source source;


    @Scheduled(fixedRate = 5000)
    public void produceHotDrinks() {
        source.output().send(
                MessageBuilder.withPayload("send a message:"+Math.random()).build());
    }


}
