package com.cyx.hibernate.test;

import com.cyx.hibernate.dao.BookShopDao;
import com.cyx.hibernate.entity.BookStock;
import com.cyx.hibernate.service.BookShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
hibernate one-to-one测试
 */
public class Main4 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springHibernate.xml");
//        BookShopService bookShopService=(BookShopService)context.getBean("bookShopService");
//        BookStock bookStock=bookShopService.getBookStock(3);
//        System.out.println(bookStock.getBookShop().getBookName());

        BookShopDao bookShopDao=(BookShopDao)context.getBean("bookShopDao");
        System.out.println(bookShopDao.getBookShop(4).getBookStock().getStock());
    }
}
