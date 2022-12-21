package com.example.parkingcarproject.model;

import com.example.parkingcarproject.Car;

public class Lot {
    int id;
    boolean reserved;
    Car carReserved;

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Car getCarReserved() {
        return carReserved;
    }

    public void setCarReserved(Car carReserved) {
        this.carReserved = carReserved;
    }

    public Lot(int id, boolean reserved) {
        this.id = id;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
