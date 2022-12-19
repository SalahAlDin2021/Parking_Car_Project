package com.example.parkingcarproject.model;

public class Lot {
    int id;
    boolean reserved;
    CarDetails carReserved;

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public CarDetails getCarReserved() {
        return carReserved;
    }

    public void setCarReserved(CarDetails carReserved) {
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
