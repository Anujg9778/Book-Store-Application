package com.example.greencommute.controller;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;
import com.example.greencommute.exception.UserNotFoundException;
import com.example.greencommute.mapper.UserMapper;
import com.example.greencommute.service.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
public class UserController {

    @Autowired
    AuthorityService authorityService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public UserDTO getUserByUserName(@RequestParam("userName") String userName){

        log.info("user name search"+userName);
        User user= authorityService.findUserByUserName(userName);

        if(user.getUserName().equals("not found"))
            throw new UserNotFoundException("User with given username does not exists");

        return userMapper.convertToUserDTO(user);
    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){

        User user=userMapper.convertToUser(userDTO);
        log.info(user.getUserName());
        User user1= authorityService.findUserByUserName(user.getUserName());

        if(!user1.getUserName().equals("not found"))
            throw new UserNotFoundException("Username already in use. please give different username");

        Authorities authority= authorityService.addUser(user);
        userDTO=userMapper.convertToUserDTOFromAuthority(authority);
        return userDTO;
    }
}
