package com.cyx.spring.aop.test;


import com.cyx.spring.aop.service.AopMethodService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        AopMethodService aopMethodService=(AopMethodService)context.getBean("aopMethodService");
        aopMethodService.say();
    }
}
