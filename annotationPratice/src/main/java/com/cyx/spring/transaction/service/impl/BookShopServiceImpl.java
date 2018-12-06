package com.cyx.spring.transaction.service.impl;

import com.cyx.spring.transaction.dao.BookShopDao;
import com.cyx.spring.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(value = "bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void buyBook() {
        int price = bookShopDao.getBookPrice("百年孤独");
        bookShopDao.updateStock(2);
        bookShopDao.updateAccount("张三", price);
    }

    /*
    事物只对public方法有效，同一个类中，事物方法调用事物方法，事物不起作用。和代理、this对象有关
     */
    @Transactional(propagation= Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,timeout = 5)
    public void buyBook2(Map<String,Object> map) {
        int price = bookShopDao.getBookPrice(map.get("bookName").toString());
        bookShopDao.updateStock((int)map.get("stockId"));
        bookShopDao.updateAccount(map.get("username").toString(), price);
    }
}
