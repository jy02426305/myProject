package com.cyx.spring.control;

import com.cyx.spring.service.AnimalService;

public class AnimalControl {
    private AnimalService animalService;

    public AnimalService getAnimalService() {
        return animalService;
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    public void call(){
        animalService.call();
    }
}
