package org.example.learn.spring.boot.rabbit.producer.producer;

import org.example.learn.spring.boot.rabbit.producer.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SimpleProducer {

    private static final Logger log = LoggerFactory.getLogger(SimpleProducer.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("{}开始发送消息. {}", this, message);
        rabbitTemplate.convertAndSend(RabbitMqConstant.SIMPLE_EXCHANGE_NAME, "", message);
    }
}
