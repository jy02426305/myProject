package com.cyx.spring.transaction.service.impl;

import com.cyx.spring.transaction.dao.BookShopDao;
import com.cyx.spring.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
