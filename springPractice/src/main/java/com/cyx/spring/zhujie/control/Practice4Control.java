package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice4Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造函数 注入
 */
public class Practice4Control {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring.xml");
        Practice4Service practice4Service=(Practice4Service)context.getBean("practice4ServiceImpl");
        practice4Service.say();
    }
}
