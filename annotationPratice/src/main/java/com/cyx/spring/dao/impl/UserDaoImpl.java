package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
    public void say() {
        System.out.println("UserDaoImpl say...");
    }
}
