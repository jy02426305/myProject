package com.cyx.spring.annotation;


import com.cyx.spring.service.BookService;
import com.cyx.spring.service.impl.SaleBookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
AnnotationConfigApplicationContext DI方式，还有一点开闭原则（面向对象编程设计原则）
 */
public class BookMain {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MyConfiguration.class);
        BookService bookService= (SaleBookServiceImpl)context.getBean("saleBookService");
        ((SaleBookServiceImpl) bookService).setSalePrice(50);
        System.out.println(((SaleBookServiceImpl) bookService).getSalePrice());
    }
}
