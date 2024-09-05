package org.example.learn.spring.boot.rabbit.producer;

import org.example.learn.spring.boot.rabbit.producer.producer.SimpleProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RabbitMQTest {

    @Resource
    private SimpleProducer simpleProducer;

    @Test
    public void sendTest() {
        for (int i = 0; i < 10000000; i++) {
            String message = String.format("测试 SpringBoot整合RabbitMq的普通模式,index=%d", i);
            simpleProducer.send(message);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("springoobt exits main");
    }
}
