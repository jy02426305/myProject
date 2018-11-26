package com.cyx.spring.control;

import com.cyx.spring.service.impl.DogServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
静态工厂方法：直接调用某一个类的静态方法就可以返回Bean实例
 */
public class Practice13Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        DogServiceImpl dogService=(DogServiceImpl)context.getBean("practice13ServiceImpl");
        System.out.println(dogService.getSound());
    }
}
