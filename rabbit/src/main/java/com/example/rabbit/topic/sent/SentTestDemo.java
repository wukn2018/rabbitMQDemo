package com.example.rabbit.topic.sent;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 * 消息生产者
 */
@Controller
public class SentTestDemo {
    @Autowired
    private AmqpTemplate rabbitTemplate;



    /**
     *方式一
     *
     * @param i
     */
    public void send2(int i) {
        //生产的消息
        User user = new User( 156,"sd" );
        String json = "my topic 1";
        String context = "生产者----mesage---->"+i;
        System.out.println("！！！ " + context);
        this.rabbitTemplate.convertAndSend("exchange","topic.message", json);

    }


    /**
     *方式二
     * .#会匹配所有的key
     * @param i
     */
    public void send3(int i) {
        //生产的消息
        User user = new User( 156,"sd" );
        String json = "my topic 2";
        String context = "生产者----mesage---->"+i;
        System.out.println("！！！ " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages",json);

    }






}
