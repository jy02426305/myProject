package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.Practice1Service;

public class Practice1ServiceImpl implements Practice1Service {
    @Override
    public void say(String word) {
        System.out.println(word);
    }
}
