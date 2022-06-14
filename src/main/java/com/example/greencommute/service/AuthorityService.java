package com.example.greencommute.service;


import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;


public interface AuthorityService{

     Authorities addUser(User user);

     User findUserByUserName(String userName);

}
