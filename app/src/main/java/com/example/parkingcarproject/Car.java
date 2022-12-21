package com.example.parkingcarproject;

public class Car {

    private String name;
    private int imageID;

    public static final Car[] cars = {
            new Car("Diavolo", R.drawable.ic_launcher_background),
            new Car("Funghi", R.drawable.ic_launcher_background),

    };

    private Car(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }
}