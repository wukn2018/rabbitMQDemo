//package com.example.rabbit.receiver;
//
///**
// *
// * @Author : Wukn
// * @Date : 2018/2/5
// */
//
//import com.alibaba.fastjson.JSON;
//import com.example.rabbit.contants.Queueame;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//
//public class NeoReceiver2 {
//
//    /**
//     * 消费方法2
//     * @param neo
//     */
//    @RabbitListener(queues = Queueame.queueName)
//    @RabbitHandler
//     public void process(String neo) {
//                 System.out.println("消费者------->2: " + JSON.parse( neo ));
//             }
//}
