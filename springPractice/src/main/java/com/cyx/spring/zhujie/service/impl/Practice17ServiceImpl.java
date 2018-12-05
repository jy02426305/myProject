package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.dao.Practice17Dao;
import com.cyx.spring.zhujie.service.Practice17Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Practice17ServiceImpl implements Practice17Service {
    private static ApplicationContext context;
    private static Practice17Dao practice17Dao;
    static {
        context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        practice17Dao=(Practice17Dao)context.getBean("practice17Dao");
    }
    @Override
    public void addZoo() {
        practice17Dao.addZoo();
    }

    public void addZoo2(){
        practice17Dao.addZoo2();
    }

    public void addZoo3(){
        practice17Dao.addZoo3();;
    }
}
