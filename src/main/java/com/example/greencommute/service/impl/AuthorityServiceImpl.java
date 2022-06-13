package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Authority;
import com.example.greencommute.entity.User;
import com.example.greencommute.exception.UserNotFoundException;
import com.example.greencommute.respository.AuthorityRepository;
import com.example.greencommute.respository.UserRepository;
import com.example.greencommute.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    private final UserRepository userRepository;

    public AuthorityServiceImpl(UserRepository userRepository,AuthorityRepository authorityRepository){
        this.authorityRepository=authorityRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Authority addUser(User user) {

        Authority authority=new Authority();
        authority.setUserName(user.getUserName());
        authority.setAuthority(user.getRole());
        User user2= userRepository.save(user);
        authority.setUser(user2);
        return authorityRepository.save(authority);
    }

    @Override
    public User findUserByUserName(String userName) {

        Optional<Authority> authority= authorityRepository.findById(userName);
        User user=null;
        if(authority.isPresent()) {
            user = authority.get().getUser();
            user.setRole(authority.get().getAuthority());
        }

        return user;
    }

}
