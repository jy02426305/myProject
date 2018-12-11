package com.cyx.hibernate.service.impl;

import com.cyx.hibernate.dao.BookShopDao;
import com.cyx.hibernate.entity.BookShop;
import com.cyx.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Override
    public int getBookPrice(String bookName) {
        return bookShopDao.getBookPrice(bookName);
    }

    @Override
    public void updateStock(int bookId) {
        bookShopDao.updateStock(bookId);
    }

    @Override
    public void updateAccount(String username, int price) {
        bookShopDao.updateAccount(username,price);
    }

    @Override
    public void buyBook(String bookName,int bookId,String username){
        int price=bookShopDao.getBookPrice(bookName);
        bookShopDao.updateStock(bookId);
        bookShopDao.updateAccount(username,price);
    }

    @Override
    public int addBook(BookShop bookShop){
        return bookShopDao.addBook(bookShop);
    }
}
