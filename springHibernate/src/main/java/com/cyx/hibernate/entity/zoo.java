package com.cyx.hibernate.entity;

import java.util.Objects;

public class Zoo {
    private int id;
    private String animalName;
    private Byte animalStatus;

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

    public Byte getAnimalStatus() {
        return animalStatus;
    }

    public void setAnimalStatus(Byte animalStatus) {
        this.animalStatus = animalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return id == zoo.id &&
                Objects.equals(animalName, zoo.animalName) &&
                Objects.equals(animalStatus, zoo.animalStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animalName, animalStatus);
    }
}
