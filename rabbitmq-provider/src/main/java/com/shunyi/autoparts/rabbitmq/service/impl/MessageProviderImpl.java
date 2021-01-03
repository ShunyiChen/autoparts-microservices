package com.shunyi.autoparts.rabbitmq.service.impl;

import com.shunyi.autoparts.rabbitmq.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Shunyi Chen
 * @create 2021-01-03 23:18
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    /** 消息发送管道 */
    @Resource
    private MessageChannel output;


    @Override
    public String send() {
        String msg = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("***********message: "+msg);
        return null;
    }
}
