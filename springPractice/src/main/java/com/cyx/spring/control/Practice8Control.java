package com.cyx.spring.control;

import com.cyx.spring.service.impl.DogFood;
import com.cyx.spring.service.impl.DogServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
配置的继承、依赖
 */
public class Practice8Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        DogServiceImpl dog=(DogServiceImpl)context.getBean("dog2");
        System.out.println(dog.getSound());
        System.out.println(dog.getDogFood().getTaste());
    }
}
