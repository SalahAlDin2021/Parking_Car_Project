package com.example.parkingcarproject.model;

import java.util.ArrayList;

public class User {
    private static int count =1;
    private int id;
    private String email ;
    private String password ;
    private ArrayList<Lot> lots=new ArrayList<>();
    private double payAmount;

    public ArrayList<Lot> getLots() {
        return lots;
    }

    public void setLots(ArrayList<Lot> lots) {
        this.lots = lots;
    }

    public double getPayAmount() {
        return payAmount;
    }
    public void addPayAmount(double payAmount) {
        this.payAmount =+ payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String email, String password) {
        id=count++;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void addLot(Lot lot){
        lots.add(lot);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
