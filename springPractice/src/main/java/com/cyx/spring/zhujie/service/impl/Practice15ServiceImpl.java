package com.cyx.spring.zhujie.service.impl;

import org.springframework.beans.factory.FactoryBean;

public class Practice15ServiceImpl implements FactoryBean<DogFood> {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public DogFood getObject() throws Exception {
        return new DogFood(state);
    }

    @Override
    public Class<?> getObjectType() {
        return DogFood.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
