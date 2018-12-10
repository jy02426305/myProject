package com.cyx.hibernate.test;

import com.cyx.hibernate.control.BookShopControl;
import com.cyx.hibernate.service.PifaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
事务的传播
 */
public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springHibernate.xml");
        BookShopControl bookShopControl=(BookShopControl)context.getBean("bookShopControl");
        bookShopControl.buyBooks();
    }
}
