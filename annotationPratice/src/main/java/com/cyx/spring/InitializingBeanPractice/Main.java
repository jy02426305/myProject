package com.cyx.spring.InitializingBeanPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        TestClass testClass=(TestClass)context.getBean("testClass");
        testClass.say();
    }
}
