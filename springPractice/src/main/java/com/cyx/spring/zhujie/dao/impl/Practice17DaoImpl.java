package com.cyx.spring.zhujie.dao.impl;

import com.cyx.spring.zhujie.dao.Practice17Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Practice17DaoImpl implements Practice17Dao {
    private static JdbcTemplate jdbcTemplate;
    static {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:springJdbcTemplate.xml");
        jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
    }
    @Override
    public void addZoo() {
        String sql="insert into zoo (animalName,animalStatus) values (?,?)";
        jdbcTemplate.update(sql,"老虎",1);
    }
}
