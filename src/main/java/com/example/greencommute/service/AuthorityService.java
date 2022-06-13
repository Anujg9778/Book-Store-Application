package com.example.greencommute.service;


import com.example.greencommute.entity.Authority;
import com.example.greencommute.entity.User;

import java.util.List;

public interface AuthorityService{

     Authority addUser(User user);

     User findUserByUserName(String userName);

}
