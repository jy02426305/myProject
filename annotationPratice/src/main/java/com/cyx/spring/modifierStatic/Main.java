package com.cyx.spring.modifierStatic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
static方法，类装载后分配内存
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        PersonService personService=(PersonService)context.getBean("lazyPersonService");
    }
}
