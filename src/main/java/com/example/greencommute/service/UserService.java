package com.example.greencommute.service;

import com.example.greencommute.entity.User;

public interface UserService {

    User findUserByUserName(String userName);

    void deleteUser(String userName);

    User saveUser(User theUser);

}
