package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private Predator predator;

    public Lion(Predator predator) {
        this.predator = predator;
    }

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int Kittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    Animal animal = new Animal();

    public List<String> getFood() throws Exception {
        return animal.getFood("Хищник");
    }
}
