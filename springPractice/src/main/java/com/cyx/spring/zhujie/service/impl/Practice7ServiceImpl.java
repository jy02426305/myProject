package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.Practice7Service;

import java.util.List;

public class Practice7ServiceImpl implements Practice7Service {
    private List<String> toy;

    public List<String> getToy() {
        return toy;
    }

    public void setToy(List<String> toy) {
        this.toy = toy;
    }
}
