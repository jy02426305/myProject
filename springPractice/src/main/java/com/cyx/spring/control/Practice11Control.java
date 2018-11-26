package com.cyx.spring.control;

import com.cyx.spring.service.impl.Practice11ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
SpEL表达式
 */
public class Practice11Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice11ServiceImpl practice11Service=(Practice11ServiceImpl)context.getBean("practice11ServiceImpl");
        System.out.println(practice11Service.getFullname());
        ((ClassPathXmlApplicationContext) context).close();
    }
}
