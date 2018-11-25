package com.cyx.spring.control;

import com.cyx.spring.service.Practice6Service;
import com.cyx.spring.service.impl.Practice6ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Practice6Control {

    public static void main(String[] args) {
//        Practice6Control practice6Control=new Practice6Control();
//        practice6Control.practice6Service.say();
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");

        Practice6Service practice6Service=(Practice6ServiceImpl)context.getBean("Practice6ServiceImpl");
        practice6Service.say();
    }
}
