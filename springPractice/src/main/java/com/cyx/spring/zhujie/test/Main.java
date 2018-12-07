package com.cyx.spring.zhujie.test;

import com.cyx.spring.zhujie.control.Practice18Control;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
xml配置文件实现声明式事务
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-tx.xml");
        Practice18Control practice18Control= (Practice18Control)context.getBean("practice18Control");
        practice18Control.buyBook2();
    }
}
