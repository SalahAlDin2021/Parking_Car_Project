package com.example.parkingcarproject.model;

import android.util.Log;

import java.util.ArrayList;

public class AdminData {


    public static ArrayList<Admin> admins =new ArrayList<>();


    public AdminData() {
        admins.add(new Admin("basil","basil@gmail.com" , "12345"));
        admins.add(new Admin("ahmad","ahmad@gmail.com" , "1234"));
        admins.add(new Admin("salah","salah@gmail.com" , "12347"));
        admins.add(new Admin("mohammad","mohammad@gmail.com" , "1234"));
        admins.add(new Admin("ali","ali@gmail.com" , "1234"));
    }


    public static int findUser(String email , String password){
        for(Admin admin : admins) {
            if (admin.getEmail().equals(email.trim()) && admin.getPassword().equals(password.trim())) {
                return admin.getId();
            }
        }
        return -1;
    }
    public static Admin findUser(int id ){
        for(Admin admin : admins) {
            if (admin.getId()==id) {
                return admin;
            }
        }
        return null;
    }

}
