package com.cyx.spring.control;

import com.cyx.spring.service.impl.Practice11ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
后置处理器BeanPostProcessor
 */
public class Practice12Control {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice11ServiceImpl practice11Service=(Practice11ServiceImpl)context.getBean("practice11ServiceImpl");
        System.out.println(practice11Service.getFullname());
        context.close();
    }
}
