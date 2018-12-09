package com.cyx.hibernate.entity;

public class zoo {
    private int id;
    private String animalName;
    private short animalStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public short getAnimalStatus() {
        return animalStatus;
    }

    public void setAnimalStatus(short animalStatus) {
        this.animalStatus = animalStatus;
    }
}
