package com.example.rabbit.web.test.exchange.sendandexchange;

import com.example.rabbit.utils.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/30
 *
 * 生产者
 */
public class SendExchangeService {

    /**
     * 队列名
     */
    public  String QUEUE_NAME2 = "test_simple_queue";


    /**
     * 交换机名
     */
    public  String QUEUE_EXANGE_NAME2 = "test_simple_queue_exchange";


    /**
     * 生产者
     */
    @Test
    public  void test01() {

        try {
            //获取连接
            Connection connection = ConnectionFactoryUtil.getConnection( );

            //获取通道
            Channel channel =  connection.createChannel();

            //申明交换机
            channel.exchangeDeclare(QUEUE_EXANGE_NAME2,"fanout" );

            //创建队列申明
            //channel.queueDeclare(QUEUE_NAME2,false,false,false,null  );

            //每个消费者发送确认消息之前只发一个，不发送下一个
            // channel.basicQos( 1 );

            for (int i = 0;i<30;++i) {
                String message = "消息---"+i;
                //发送消息到交换机
                channel.basicPublish( "",QUEUE_EXANGE_NAME2,null,message.getBytes() );
                System.out.println("发送消息。。。"+message);
            }

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace( );
        }

    }
}
