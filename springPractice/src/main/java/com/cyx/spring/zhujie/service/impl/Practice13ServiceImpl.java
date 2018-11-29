package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.AnimalService;

import java.util.HashMap;
import java.util.Map;

public class Practice13ServiceImpl {
    public static Map<String, AnimalService> animal=new HashMap<>();
    static {
        AnimalService dog=new DogServiceImpl();
        AnimalService cat=new CatServiceImpl();
        animal.put("dog",dog);
        animal.put("cat",cat);
    }

    //静态工厂方法
    public static DogServiceImpl getDogServiceImpl(String name){
        return (DogServiceImpl)animal.get(name);
    }
}
