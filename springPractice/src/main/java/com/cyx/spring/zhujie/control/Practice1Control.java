package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice1Service;
import com.cyx.spring.zhujie.service.impl.Practice1ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 最简单DI
 */
public class Practice1Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice1Service practice1Service=(Practice1ServiceImpl)context.getBean("practice1ServiceImpl");
        practice1Service.say("丢嘞楼某");
    }
}
