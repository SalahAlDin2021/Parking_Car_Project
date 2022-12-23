package com.example.parkingcarproject.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Lot {

    int id;
    boolean reserved;
    User userReserved;
    double dueration;
    long start;
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

    public long getStart() {
        return start;
    }

    public double getPrice() {
        return price;
    }

    public void setReserved(User user, double dueration) {
        this.reserved = true;
        Date date=new Date();
        this.start= date.getTime();
        this.dueration=dueration;
        this.userReserved=user;
        this.price=dueration*PRICE_PER_HOUR;

    }
    public void checkifEnd(){
        if(reserved){
            Date date =new Date();
            long time= date.getTime();
            if(time-start>=dueration*60*60*1000){
                reserved=false;
            }
        }
    }

    public User getCarReserved() {
        return userReserved;
    }

    public void setCarReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", reserved=" + reserved +
                ", userReserved=" + userReserved +
                ", dueration=" + dueration +
                ", start=" + start +
                ", price=" + price +
                '}';
    }
}
