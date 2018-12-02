package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.dao.Practice6Dao;
import com.cyx.spring.zhujie.service.Practice6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Practice6ServiceImpl implements Practice6Service {
    @Autowired
    private Practice6Dao practice6Dao;

    public void say(){
        practice6Dao.say();
    }
}
