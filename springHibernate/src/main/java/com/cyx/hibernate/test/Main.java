package com.cyx.hibernate.test;

import com.cyx.hibernate.service.BookShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springHibernate.xml");
        BookShopService bookShopService=(BookShopService)context.getBean("bookShopService");
        String bookNmae="百年孤独";
        System.out.println("《" + bookNmae + "》的价格：" + bookShopService.getBookPrice(bookNmae));
    }
}
