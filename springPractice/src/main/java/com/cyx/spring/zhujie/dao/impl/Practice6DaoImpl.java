package com.cyx.spring.zhujie.dao.impl;

import com.cyx.spring.zhujie.dao.Practice6Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

public class Practice6DaoImpl implements Practice6Dao {
    @Override
    public void say() {
        System.out.println("hello");
    }
}
