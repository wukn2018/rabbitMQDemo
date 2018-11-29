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
public class NeoReceiver11 {


    /**
     * 消费方法1
     * @param neo
     */
    @RabbitListener(queues = "topic.message")
    @RabbitHandler
      public void process(String neo) {
                 System.out.println("消费者------>1: " +  neo );
            }


}
