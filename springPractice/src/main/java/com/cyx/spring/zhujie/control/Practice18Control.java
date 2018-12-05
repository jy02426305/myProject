package com.cyx.spring.zhujie.control;

import com.cyx.spring.zhujie.service.Practice18Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 声明式事务
 */
public class Practice18Control {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        Practice18Service practice18Service=(Practice18Service)context.getBean("practice18Service");
        practice18Service.buyBook();
    }
}
