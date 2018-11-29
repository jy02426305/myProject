package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.AnimalService;

import java.util.HashMap;
import java.util.Map;

/*
实例
 */
public class Practice14ServiceImpl {
    private Map<String, AnimalService> animal;

    public Practice14ServiceImpl(){
        animal=new HashMap<>();
        DogServiceImpl dog=new DogServiceImpl();
        CatServiceImpl cat=new CatServiceImpl();
        animal.put("dog",dog);
        animal.put("cat",cat);
    }

    public DogServiceImpl getDog(String name){
        return (DogServiceImpl)animal.get(name);
    }
    public CatServiceImpl getCat(String name){
        return (CatServiceImpl) animal.get(name);
    }
}
