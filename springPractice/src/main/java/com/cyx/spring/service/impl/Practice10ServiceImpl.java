package com.cyx.spring.service.impl;

import com.cyx.spring.service.Practice10Service;

public class Practice10ServiceImpl implements Practice10Service {
    public Practice10ServiceImpl(){
        System.out.println("Practice9ServiceImpl初始化完成");
    }

    @Override
    public void say() {
        System.out.println("你好啊");
    }
}
