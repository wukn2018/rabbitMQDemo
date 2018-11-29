package com.example.rabbit.web.test.customerandsend.customer;

import com.example.rabbit.utils.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/30
 */
public class CustomerTow {

    public  String QUEUE_NAME2 = "test_simple_queue";




    /**
     * 消费消息1
     */
    @Test
    public void test03() {

        try {
            //获取连接
            Connection connection = ConnectionFactoryUtil.getConnection( );

            //获取通道
            Channel channel =  connection.createChannel();

            //通过channel指定队列
            channel.queueDeclare(QUEUE_NAME2,false,false,false,null  );

            // .创建一个消费者队列consumer,并指定channel
            QueueingConsumer consumer = new QueueingConsumer(channel);

            //7.为channel指定消费者
            channel.basicConsume(QUEUE_NAME2, true, consumer);
            while (true) {
                // 从consumer中获取队列中的消息,nextDelivery是一个阻塞方法,如果队列中无内容,则等待
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("【消费者1接收到了\" + QUEUE_NAME + \"中的消息:】---" + message);
            }
        } catch (Exception e) {
            e.printStackTrace( );
        }

    }








}
