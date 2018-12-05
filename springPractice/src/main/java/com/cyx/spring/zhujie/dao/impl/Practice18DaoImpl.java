package com.cyx.spring.zhujie.dao.impl;

import com.cyx.spring.zhujie.dao.Practice18Dao;
import com.cyx.spring.zhujie.dto.AccountException;
import com.cyx.spring.zhujie.dto.StockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class Practice18DaoImpl implements Practice18Dao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getBookPrice(String bookName) {
        String sql="select price from book_shop where bookName=?";
        Integer price= jdbcTemplate.queryForObject(sql,Integer.class,bookName);
        return price;
    }

    @Override
    public void updateStock(int stockId) {
        String sql2="select stock from book_stock where id=?";
        Integer stock=jdbcTemplate.queryForObject(sql2,Integer.class,stockId);
        if(stock==0){
            throw new StockException("库存不足！");
        }

        String sql="update book_stock set stock=stock-1 where id=?";
        jdbcTemplate.update(sql,stockId);
    }

    @Override
    public void updateAccount(String username, int price) {
        String sql2="select balance from user_account where username=?";
        Integer balance=jdbcTemplate.queryForObject(sql2,Integer.class,username);
        if(balance<price){
            throw new AccountException("余额不足！");
        }

        String sql="update user_account set balance=balance-? where username=?";
        jdbcTemplate.update(sql,price,username);
    }
}
