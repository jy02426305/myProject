package com.cyx.spring.service.impl;

import com.cyx.spring.service.Practice3Service;

public class Practice3ServiceImpl implements Practice3Service {
    public void start() {
        System.out.println("spring生命周期开始");
    }

    public void end() {
        System.out.println("spring销毁");
    }

    public void life() {
        System.out.println("spring生命周期内");
    }
}
