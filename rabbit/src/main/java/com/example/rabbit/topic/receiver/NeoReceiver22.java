package com.example.rabbit.topic.receiver;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 */
@Component
public class NeoReceiver22 {

    /**
     * 消费方法2
     * @param neo
     */
    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
     public void process(String neo) {
                 System.out.println("消费者------->2: " + neo );
             }
}
