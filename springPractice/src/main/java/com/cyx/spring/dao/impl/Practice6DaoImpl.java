package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.Practice6Dao;
import org.springframework.stereotype.Repository;

@Repository
public class Practice6DaoImpl implements Practice6Dao {
    @Override
    public void say() {
        System.out.println("hello");
    }
}
