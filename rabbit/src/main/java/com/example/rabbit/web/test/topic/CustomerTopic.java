package com.example.rabbit.web.test.topic;

import com.example.rabbit.utils.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class CustomerTopic {


    /**
     * 队列名
     */
    public  String QUEUE_NAME2 = "test_simple_queue_topic1";


    /**
     * 交换机名
     */
    public  String QUEUE_EXANGE_NAME2 = "test_simple_queue_exchangetopic";



    /**
     * 消费消息2
     */
    @Test
    public void test033() throws Exception{
            //获取连接
            Connection connection = ConnectionFactoryUtil.getConnection( );

            //获取通道
            Channel channel =  connection.createChannel();

            //通过channel指定队列
            channel.queueDeclare(QUEUE_NAME2,false,false,false,null  );

            //交换机类型
            //channel.exchangeDeclare(QUEUE_EXANGE_NAME2, "topic");

            String routingkey = "good.*";
            //绑定队列到交换机
            channel.queueBind(QUEUE_NAME2,QUEUE_EXANGE_NAME2,routingkey  );

            //保证只分发一次
            //channel.basicQos( 1 );


            // .创建一个消费者队列consumer,并指定channel
            QueueingConsumer consumer = new QueueingConsumer(channel);

            //7.指定接收者，第二个参数为自动应答，无需手动应答
            channel.basicConsume(QUEUE_NAME2, true, consumer);

            while (true) {
                // 从consumer中获取队列中的消息,nextDelivery是一个阻塞方法,如果队列中无内容,则等待
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("【消费者2接收到了\" + QUEUE_NAME + \"中的消息:】---" + message);
            }

    }
}
