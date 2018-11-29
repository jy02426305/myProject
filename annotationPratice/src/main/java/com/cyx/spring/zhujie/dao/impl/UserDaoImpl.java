package com.cyx.spring.zhujie.dao.impl;

import com.cyx.spring.zhujie.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
    public void say() {
        System.out.println("UserDaoImpl say...");
    }
}
