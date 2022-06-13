package com.example.greencommute.controller;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.Authority;
import com.example.greencommute.entity.User;
import com.example.greencommute.exception.UserNotFoundException;
import com.example.greencommute.mapper.UserMapper;
import com.example.greencommute.service.AuthorityService;
import com.example.greencommute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public UserDTO getUserByUserName(@RequestParam("userName") String userName){

        User user= authorityService.findUserByUserName(userName);

        log.info(user.getRole());
        if(user==null)
            throw new UserNotFoundException("User with given username does not exists");
        return userMapper.convertToUserDTO(user);

    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){

        User user=userMapper.convertToUser(userDTO);
        User user1= authorityService.findUserByUserName(user.getUserName());
        if(user1!=null)
            throw new UserNotFoundException("Username already in use. please give different username");

        Authority authority= authorityService.addUser(user);
        userDTO=userMapper.convertToUserDTOFromAuthority(authority);
        return userDTO;
    }

}
