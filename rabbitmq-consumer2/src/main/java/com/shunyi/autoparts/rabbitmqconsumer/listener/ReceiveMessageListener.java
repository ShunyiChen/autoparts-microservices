package com.shunyi.autoparts.rabbitmqconsumer.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Shunui Chen
 * @create 2021-01-03 23:56
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void listener(Message<String> message) {
        System.out.println("*******消息者2号："+message.getPayload()+"\t port"+serverPort);
    }
}
