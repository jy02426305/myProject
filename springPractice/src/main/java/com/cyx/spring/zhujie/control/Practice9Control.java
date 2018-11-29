package com.cyx.spring.zhujie.control;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/*
数据库连接/外部配置文件引用
 */
public class Practice9Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        DataSource dataSource=(DataSource)context.getBean("dataSource");
        System.out.println(dataSource.toString());
    }
}
