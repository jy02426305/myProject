package com.cyx.spring.transaction.test;

import com.cyx.spring.transaction.control.BookShopControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 声明式事务
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        BookShopControl bookShopControl=(BookShopControl)context.getBean("bookShopControl");
        bookShopControl.buyBook();
    }
}
