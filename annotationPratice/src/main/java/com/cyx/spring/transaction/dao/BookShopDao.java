package com.cyx.spring.transaction.dao;

public interface BookShopDao {
    /**
     *获取书本单价
     * @param bookName
     * @return
     */
    int getBookPrice(String bookName);

    /**
     * 减少库存
     * @param stockId
     */
    void updateStock(int stockId);

    /**
     * 更新账户余额
     * @param username
     * @param price
     */
    void updateAccount(String username,int price);
}
