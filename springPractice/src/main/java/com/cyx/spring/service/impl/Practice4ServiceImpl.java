package com.cyx.spring.service.impl;

import com.cyx.spring.service.Practice4Service;

public class Practice4ServiceImpl implements Practice4Service {
    private String name;
    public Practice4ServiceImpl(String name){
        this.name=name;
    }
    @Override
    public void say() {
        System.out.println("我是："+this.name);
    }
}
