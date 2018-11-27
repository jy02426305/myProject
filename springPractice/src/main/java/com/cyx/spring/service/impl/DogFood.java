package com.cyx.spring.service.impl;

public class DogFood {
    public DogFood(){
        System.out.println("dogFood初始化完成");
    }

    public DogFood(String taste){
        this.taste=taste;
    }

    private String taste;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
