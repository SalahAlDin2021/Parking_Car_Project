package com.example.parkingcarproject.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Lot {

    int id;
    boolean reserved;
    User userReserved;
    double dueration;
    double start;
    double price;


    public static final double PRICE_PER_HOUR = 5.0;

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

    public boolean isReserved() {
        return reserved;
    }

    public User getUserReserved() {
        return userReserved;
    }

    public double getDueration() {
        return dueration;
    }

    public double getStart() {
        return start;
    }

    public double getPrice() {
        return price;
    }

    public void setReserved(User user, double dueration) {
        this.reserved = true;
        Calendar dt= GregorianCalendar.getInstance();
        this.start= dt.HOUR_OF_DAY+dt.MINUTE/60;
        this.dueration=dueration;
        this.userReserved=user;
        this.price=dueration*PRICE_PER_HOUR;

    }

    public User getCarReserved() {
        return userReserved;
    }

    public void setCarReserved(User userReserved) {
        this.userReserved = userReserved;
    }

}
