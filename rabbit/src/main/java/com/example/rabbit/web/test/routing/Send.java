package com.example.rabbit.web.test.routing;

import com.example.rabbit.utils.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class Send {

    /**
     * 队列名
     */
    public  String QUEUE_NAME2 = "test_simple_queue_direct1";


    /**
     * 交换机名
     */
    public  String QUEUE_EXANGE_NAME2 = "test_simple_queue_exchangedirect";


    /**
     * 生产者
     */
    @Test
    public  void test02() {

        try {
            //获取连接
            Connection connection = ConnectionFactoryUtil.getConnection( );

            //获取通道
            Channel channel =  connection.createChannel();

            //申明交换机  和交换机类型
            channel.exchangeDeclare(QUEUE_EXANGE_NAME2,"direct" );

            //创建队列申明
            //channel.queueDeclare(QUEUE_NAME2,false,false,false,null  );

            //每个消费者发送确认消息之前只发一个，不发送下一个
            // channel.basicQos( 1 );


            String message = "消息---"+"direct";

            //发送消息到交换机   定义routingkey
            String routingkey = "error";
            channel.basicPublish( QUEUE_EXANGE_NAME2,routingkey,null,message.getBytes() );
            System.out.println("发送消息。。。"+message);

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace( );
        }

    }
}
