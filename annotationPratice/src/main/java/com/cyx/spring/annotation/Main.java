package com.cyx.spring.annotation;

import com.cyx.spring.control.UserControl;
import com.cyx.spring.dao.UserDao;
import com.cyx.spring.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
//        UserDao userDao=(UserDaoImpl)context.getBean("userDao");
//        userDao.say();
//        UserControl userControl=(UserControl)context.getBean("userControl");
//        userControl.showSelf();

        UserControl userControl=(UserControl)context.getBean("userControl");
        userControl.say();
    }
}
