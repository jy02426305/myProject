package com.cyx.hibernate.dao;

public interface BookShopDao {
    int getBookPrice(String bookName);

    void updateStock(int bookId);

    void updateAccount(String username,int price);
}
