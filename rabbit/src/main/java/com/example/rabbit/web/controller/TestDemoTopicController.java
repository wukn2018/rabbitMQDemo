package com.example.rabbit.web.controller;
import com.example.rabbit.sent.SentTest;
import com.example.rabbit.topic.sent.SentTestDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 */
@RestController
@RequestMapping(value = "topic")
public class TestDemoTopicController {

    @Autowired
    private SentTestDemo sentTest;



    @GetMapping(value = "/test1")
    @ResponseBody
    public String find1() throws Exception{
        for(int i = 0;i<=10;++i) {
            sentTest.send2(i);
        }
        return "ok";
    }
    @GetMapping(value = "/test2")
    @ResponseBody
    public String find2() throws Exception{
        for(int i = 0;i<=10;++i) {
            sentTest.send3(i);
        }
        return "ok";
    }






}
