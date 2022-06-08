package com.example.greencommute.service.impl;


import com.example.greencommute.entity.User;
import com.example.greencommute.respository.UserRepository;
import com.example.greencommute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<User> findUser(int theUserId) {
        return userRepository.findById(theUserId);
    }

    @Override
    @Transactional
    public void deleteUser(int theUserId) {
         userRepository.deleteById(theUserId);
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        userRepository.save(theUser);
    }
}
