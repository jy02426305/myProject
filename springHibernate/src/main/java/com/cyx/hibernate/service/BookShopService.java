package com.cyx.hibernate.service;

import com.cyx.hibernate.entity.BookShop;
import com.cyx.hibernate.entity.BookStock;

public interface BookShopService {
    int getBookPrice(String bookName);

    void updateStock(int bookId);

    void updateAccount(String username,int price);

    void buyBook(String bookName,int bookId,String username);

    int addBook(BookShop bookShop);

    BookStock getBookStock(int id);
}
