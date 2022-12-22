package com.example.parkingcarproject.model;

import com.example.parkingcarproject.R;

public class Car {

    private String name;



    public static final Car[] cars = {
            new Car("Diavolo"),
            new Car("Funghi"),

    };

    private Car(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}