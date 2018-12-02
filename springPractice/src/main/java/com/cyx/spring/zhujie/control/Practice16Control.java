package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice16Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
aop切面xml注解
 */
public class Practice16Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springAspect.xml");
        Practice16Service practice16Service= (Practice16Service)context.getBean("practice16Service");
        System.out.println(practice16Service.calculationAdd(1, 2));
    }
}
