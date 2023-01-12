package com.gabrielortelan.animelist.AnimeProject.service;

import com.gabrielortelan.animelist.AnimeProject.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserMock {

    public static List<User> createUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User("2","Maria","maria@gmail.com");
        User user2 = new User("1","Jose","jose@gmail.com");
        User user3 = new User("3", "Gustavo","gustavo@gmail.com");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}
