package com.cyx.hibernate.test;

import com.cyx.hibernate.entity.BookShop;
import com.cyx.hibernate.service.BookShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
hibernate实体类映射
 */
public class Main3 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springHibernate.xml");
        BookShopService bookShopService=(BookShopService)context.getBean("bookShopService");
        BookShop bookShop=new BookShop();
        bookShop.setBookName("红高粱");
        bookShop.setPrice(30);
        bookShopService.addBook(bookShop);
    }
}
