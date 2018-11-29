package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.Practice3Service;

public class Practice3ServiceImpl implements Practice3Service {
    @Override
    public void start() {
        System.out.println("spring生命周期开始");
    }
    @Override
    public void end() {
        System.out.println("spring销毁");
    }
    @Override
    public void life() {
        System.out.println("spring生命周期内");
    }
}
