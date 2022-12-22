package com.example.parkingcarproject.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {


    public static List<User> users=new ArrayList<>();


    public UserData() {
        users.add(new User("basil@gmail.com" , "12345"));
        users.add(new User("ahmad@gmail.com" , "1234"));
        users.add(new User("salah@gmail.com" , "12347"));
        users.add(new User("mohammad@gmail.com" , "1234"));
        users.add(new User("ali@gmail.com" , "1234"));
    }


    public static int findUser(String userName , String password){
        for(User user : users ) {
            if (user.getEmail().equals(userName) && user.getPassword().equals(password)) {
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
