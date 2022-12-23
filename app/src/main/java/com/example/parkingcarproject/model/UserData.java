package com.example.parkingcarproject.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {


    public static ArrayList<User> users=new ArrayList<>();


    public UserData() {
        users.add(new User("basil","basil@gmail.com" , "12345"));
        users.add(new User("ahmad","ahmad@gmail.com" , "1234"));
        users.add(new User("salah","salah@gmail.com" , "12347"));
        users.add(new User("mohammad","mohammad@gmail.com" , "1234"));
        users.add(new User("ali","ali@gmail.com" , "1234"));
    }


    public static int findUser(String email , String password){
        for(User user : users ) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return -1;
    }
    public static User findUser(int id ){
        for(User user : users ) {
            if (user.getId()==id) {
                return user;
            }
        }
        return null;
    }

}
