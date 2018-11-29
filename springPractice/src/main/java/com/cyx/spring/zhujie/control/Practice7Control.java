package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.impl.Practice7ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
util定义集合  供bean调用练习
 */
public class Practice7Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice7ServiceImpl practice7Service=(Practice7ServiceImpl)context.getBean("practice7ServiceImpl");
        System.out.println(practice7Service.getToy().get(0));
    }
}
