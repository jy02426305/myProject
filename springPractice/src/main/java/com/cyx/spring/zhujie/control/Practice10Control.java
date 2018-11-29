package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice10Service;
import com.cyx.spring.zhujie.service.impl.Practice10ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
lazy延迟加载
 */
public class Practice10Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice10Service practice10Service=(Practice10ServiceImpl)context.getBean("practice10ServiceImpl");
        practice10Service.say();
    }
}
