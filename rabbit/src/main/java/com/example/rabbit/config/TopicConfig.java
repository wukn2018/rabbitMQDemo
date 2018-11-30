package com.example.rabbit.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/30
 */
@Configuration
public class TopicConfig {


    /**
     * //只接一个topic
     */
    final static String message = "topic.message";

    /**
     *  //接收多个topic
     */
    final static String messages = "topic.messages";



    /**
     * 队列1
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue(message);
    }


    /**
     * 队列2
     * @return
     */
    @Bean
    public Queue queueMessages() {
        return new Queue(messages);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }






















}
