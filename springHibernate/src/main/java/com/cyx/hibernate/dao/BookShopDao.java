package com.cyx.hibernate.dao;

import com.cyx.hibernate.entity.BookShop;
import com.cyx.hibernate.entity.BookStock;

public interface BookShopDao {
    int getBookPrice(String bookName);

    void updateStock(int bookId);

    void updateAccount(String username,int price);

    int addBook(BookShop bookShop);

    BookStock getBookStock(int bookId);

    BookShop getBookShop(int id);
}
