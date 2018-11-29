package com.cyx.spring.fanxingyilaizhuru.test;

import com.cyx.spring.fanxingyilaizhuru.control.AnimalControl;
import com.cyx.spring.fanxingyilaizhuru.control.PersonControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
//        PersonControl personControl=(PersonControl)context.getBean("personControl");
//        personControl.say();

        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        AnimalControl animalControl=(AnimalControl)context.getBean("animalControl");
        animalControl.doSomething();
    }
}
