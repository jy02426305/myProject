package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice3Service;
import com.cyx.spring.zhujie.service.impl.Practice3ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring生命周期
 */
public class Practice3Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice3Service practice3Service=context.getBean(Practice3ServiceImpl.class);//用这种方法，需要确定Practice3ServiceImpl在配置文件里是唯一的，不能有两个<bean>指向Practice3ServiceImpl
        practice3Service.life();
//        context.registerShutdownHook
        //context.close();
    }
}
