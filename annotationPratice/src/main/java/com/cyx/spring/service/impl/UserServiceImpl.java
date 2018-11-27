package com.cyx.spring.service.impl;

import com.cyx.spring.dao.UserDao;
import com.cyx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    @Qualifier("userDao") //指定bean名称
    private UserDao userDao;//未设置@Qualifier，且该bean类型在ioc容器中有多个，则以变量名为bean名称去容器中寻找

    /*
        name为bean名称
         */
    @Resource(name="orderDao")
    private UserDao orderDao;

    @Override
    public void sayUser() {
        userDao.say();
    }

    @Override
    public void sayOrder() {
        orderDao.say();
    }

    @Override
    public void showSelf() {
        System.out.println("UserServiceImpl showSelf...");
    }
}
