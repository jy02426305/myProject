package com.cyx.spring.fanxingyilaizhuru.dao.impl;

import com.cyx.spring.fanxingyilaizhuru.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
    public void say(){
        System.out.println(this);
    }
}
