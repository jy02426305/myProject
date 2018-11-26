package com.cyx.spring.service.impl;

import com.cyx.spring.service.Practice4Service;

public class Practice4ServiceImpl implements Practice4Service {
    private String name;
    private int num;
    public Practice4ServiceImpl(String name,int num){
        this.name=name;
        this.num= num;
    }
    @Override
    public void say() {
        System.out.println("我是："+this.name+"，我的编号："+this.num);
    }
}
