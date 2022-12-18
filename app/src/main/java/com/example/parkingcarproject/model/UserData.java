package com.example.parkingcarproject.model;

import java.util.List;

public class UserData implements IUserData{


    private List<User> users;


    public UserData() {
        users.add(new User("basil@gmail.com" , "1234"));
        users.add(new User("ahmad@gmail.com" , "1234"));
        users.add(new User("salah@gmail.com" , "1234"));
        users.add(new User("mohammad@gmail.com" , "1234"));
        users.add(new User("ali@gmail.com" , "1234"));
    }


    public boolean findUser(String userName , String password){
        boolean bool =false ;
        for(User user : users ) {
            if (user.getEmail().equals(userName) && user.getPassword().equals(password)) {
                bool =true;
            }else {
                bool = false;
            }
        }
        return bool;
    }

}
