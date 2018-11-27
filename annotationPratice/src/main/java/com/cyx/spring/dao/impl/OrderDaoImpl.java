package com.cyx.spring.dao.impl;

import com.cyx.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/*
如果@Repository不设置value，则默认去bean里找该类型的bean，如出现多个相同类型，会报错。
 */
@Repository(value="orderDao")
public class OrderDaoImpl implements UserDao {
    public void say() {
        System.out.println("OrderDaoImpl say...");
    }
}
