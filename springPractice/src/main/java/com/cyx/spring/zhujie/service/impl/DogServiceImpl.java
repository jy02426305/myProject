package com.cyx.spring.zhujie.service.impl;

import com.cyx.spring.zhujie.service.AnimalService;

public class DogServiceImpl implements AnimalService {
    public DogServiceImpl() {
        System.out.println("dogServiceImpl初始化完成");
    }

    private String sound;
    private DogFood dogFood;

    public DogFood getDogFood() {
        return dogFood;
    }

    public void setDogFood(DogFood dogFood) {
        this.dogFood = dogFood;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public void call() {
        System.out.println(this.sound);
    }
}
