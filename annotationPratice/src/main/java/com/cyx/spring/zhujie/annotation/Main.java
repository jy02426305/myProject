package com.cyx.spring.zhujie.annotation;

import com.cyx.spring.zhujie.control.UserControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解
 */
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
