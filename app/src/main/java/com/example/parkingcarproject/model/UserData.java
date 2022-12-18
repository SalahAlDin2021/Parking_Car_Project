package com.example.parkingcarproject.model;

import java.util.List;

public class UserData implements IUserData{


    private List<User> users;


    public UserData() {
        users.add(new User("Basil" , "1234"));
        users.add(new User("Ahmad" , "1234"));
        users.add(new User("Salah" , "1234"));
        users.add(new User("Mohammad" , "1234"));
        users.add(new User("Ali" , "1234"));
    }


    public boolean findUser(String userName , String password){
        boolean bool =false ;
        for(User user : users ) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                bool =true;
            }else {
                bool = false;
            }
        }
        return bool;
    }

}
