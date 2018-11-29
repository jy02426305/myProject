package com.cyx.spring.fanxingyilaizhuru.service.impl;

import com.cyx.spring.fanxingyilaizhuru.dao.BaseDao;
import com.cyx.spring.fanxingyilaizhuru.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService {
    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public void say() {
        baseDao.say();
    }
}
