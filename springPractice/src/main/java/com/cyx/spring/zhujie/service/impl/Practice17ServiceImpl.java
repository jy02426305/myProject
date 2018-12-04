package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.dao.Practice17Dao;
import com.cyx.spring.zhujie.service.Practice17Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Practice17ServiceImpl implements Practice17Service {
//    private Practice17Dao practice17Dao;
    @Override
    public void addZoo() {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        Practice17Dao practice17Dao=(Practice17Dao)context.getBean("practice17Dao");
        practice17Dao.addZoo();
    }
}
