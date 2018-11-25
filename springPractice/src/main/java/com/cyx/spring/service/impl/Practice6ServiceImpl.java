package com.cyx.spring.service.impl;

import com.cyx.spring.dao.Practice6Dao;
import com.cyx.spring.service.Practice6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Practice6ServiceImpl implements Practice6Service {

    @Autowired
    private Practice6Dao practice6Dao;

    public void say(){
        practice6Dao.say();
    }
}
