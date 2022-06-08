package com.example.greencommute.service;

import com.example.greencommute.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findUser(int theUserId);

    void deleteUser(int theUserId);

    void saveUser(User theUser);

}
