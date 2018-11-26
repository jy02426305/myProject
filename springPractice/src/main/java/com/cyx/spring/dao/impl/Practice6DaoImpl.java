package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.Practice6Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("practice6Dao")
@Scope("singleton") //作用范围，默认单例
public class Practice6DaoImpl implements Practice6Dao {
    @Override
    public void say() {
        System.out.println("hello");
    }
}
