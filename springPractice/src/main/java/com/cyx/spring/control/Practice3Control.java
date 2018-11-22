package com.cyx.spring.control;

import com.cyx.spring.service.Practice3Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring生命周期
 */
public class Practice3Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice3Service practice3Service=(Practice3Service)context.getBean("practice3ServiceImpl");
        practice3Service.life();
//        context.registerShutdownHook
        //context.close();
    }
}
