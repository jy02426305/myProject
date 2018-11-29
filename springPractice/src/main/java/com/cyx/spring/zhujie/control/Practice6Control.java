package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice6Service;
import com.cyx.spring.zhujie.service.impl.Practice6ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/*
注解
 */
@Controller
public class Practice6Control {
    @Autowired(required = false)
    private Practice6Service practice6Service;

    public static void main(String[] args) {
//        Practice6Control practice6Control=new Practice6Control();
//        practice6Control.practice6Service.say();
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice6Service practice6Service=(Practice6ServiceImpl)context.getBean("practice6Service");
        practice6Service.say();
    }
}
