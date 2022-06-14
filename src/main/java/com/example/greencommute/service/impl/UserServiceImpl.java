package com.example.greencommute.service.impl;

import com.example.greencommute.entity.User;
import com.example.greencommute.respository.UserRepository;
import com.example.greencommute.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User theUser) {
        return userRepository.save(theUser);
    }
}
