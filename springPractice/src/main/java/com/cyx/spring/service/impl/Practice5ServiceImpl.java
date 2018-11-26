package com.cyx.spring.service.impl;

import com.cyx.spring.service.Practice5Service;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Practice5ServiceImpl implements Practice5Service{
    private int[] intAry;
    private List list;
    private Map map;
    private Properties prop;
    private DogServiceImpl dog;

    public DogServiceImpl getDog() {
        return dog;
    }

    public void setDog(DogServiceImpl dog) {
        this.dog = dog;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public int[] getIntAry() {
        return intAry;
    }

    public void setIntAry(int[] intAry) {
        this.intAry = intAry;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void say() {

    }
}
