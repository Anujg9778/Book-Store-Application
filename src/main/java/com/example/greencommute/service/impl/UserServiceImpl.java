package com.example.greencommute.service.impl;


import com.example.greencommute.entity.User;
import com.example.greencommute.respository.UserRepository;
import com.example.greencommute.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public void deleteUser(String userName) {
        userRepository.deleteUserByUserName(userName);
    }

    @Override
    public User saveUser(User theUser) {
        return userRepository.save(theUser);
    }
}
