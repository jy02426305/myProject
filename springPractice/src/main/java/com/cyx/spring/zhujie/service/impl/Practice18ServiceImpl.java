package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.dao.Practice18Dao;
import com.cyx.spring.zhujie.service.Practice18Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class Practice18ServiceImpl implements Practice18Service {

    private Practice18Dao practice18Dao;

    public Practice18Dao getPractice18Dao() {
        return practice18Dao;
    }

    public void setPractice18Dao(Practice18Dao practice18Dao) {
        this.practice18Dao = practice18Dao;
    }

    @Transactional
    @Override
    public void buyBook() {
        int price = practice18Dao.getBookPrice("百年孤独");
        practice18Dao.updateStock(2);
        practice18Dao.updateAccount("张三", price);
    }

    @Override
    public void buyBook2(String bookName,int stockId){
        int price = practice18Dao.getBookPrice(bookName);
        practice18Dao.updateStock(stockId);
        practice18Dao.updateAccount("张三", price);
    }
}
