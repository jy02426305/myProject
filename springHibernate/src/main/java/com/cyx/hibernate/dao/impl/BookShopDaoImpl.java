package com.cyx.hibernate.dao.impl;

import com.cyx.hibernate.dao.BookShopDao;
import com.cyx.hibernate.entity.BookShop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int getBookPrice(String bookName) {
        String sql="select b.price from book_shop b where b.bookName=?0";
//        String sql="select b.price from book_shop b where b.bookName=?";//不加序号，默认从1开始
        NativeQuery query= getSession().createSQLQuery(sql).setParameter(0,bookName);
        return (Integer)query.uniqueResult();
    }

    @Override
    public void updateStock(int bookId){
        String sql2="select stock from book_stock where bookId=?0";
        Query query2=getSession().createSQLQuery(sql2).setParameter(0,bookId);
        int stock=(Integer) query2.uniqueResult();
        if(stock==0){
            throw new RuntimeException("库存不足！");
        }

        String sql="update book_stock set stock=stock-1 where bookId=?";
        Query query=getSession().createSQLQuery(sql).setParameter(1,bookId);
        query.executeUpdate();
    }

    @Override
    public void updateAccount(String username,int price){
        String sql2="select balance from user_account where username=?0";
        Query query2=getSession().createSQLQuery(sql2).setParameter(0,username);
        int balance=(Integer) query2.uniqueResult();
        if(price>balance){
            throw new RuntimeException("余额不足！");
        }

        String sql="update user_account set balance=balance-?0 where username=?1";
        Query query=getSession().createSQLQuery(sql).setParameter(0,price).setParameter(1,username);
        query.executeUpdate();
    }
}
