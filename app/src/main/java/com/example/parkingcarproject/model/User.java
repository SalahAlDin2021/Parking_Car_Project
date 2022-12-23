package com.example.parkingcarproject.model;

import java.util.ArrayList;

public class User {
    private String username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String username,String email, String password) {
        id=count++;
        this.username=username;
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
    public double calculate_price_of_lots(){
        double amount=0.0;
        for(Lot lot:lots){
            amount+=lot.price;
        }
        return amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
