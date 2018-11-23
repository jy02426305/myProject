package com.cyx.spring.service.impl;

import com.cyx.spring.service.AnimalService;

public class CatServiceImpl implements AnimalService {
    private String sound;

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
