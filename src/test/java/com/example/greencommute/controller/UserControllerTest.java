package com.example.greencommute.controller;

import com.example.greencommute.dto.UserDTO;
import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;
import com.example.greencommute.mapper.UserMapper;
import com.example.greencommute.service.AuthorityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    AuthorityService authorityService;

    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserController userController;

    @Test
    void getUserByUserNameTest(){

        User user=new User("shiv","shiv123",1);
        user.setRole("User");
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        Authorities authority=new Authorities("shiv","shiv123");
        authority.setUser(user);

        Mockito.when(authorityService.findUserByUserName("shiv")).thenReturn(user);
        Mockito.when(userMapper.convertToUserDTO(user)).thenReturn(userDTO);

        UserDTO userDTO1=userController.getUserByUserName("shiv");
        assertEquals(userDTO.getUserName(),userDTO1.getUserName());
        assertEquals(userDTO.getPassword(),userDTO1.getPassword());
        assertEquals(userDTO.getRole(),userDTO1.getRole());

        verify(authorityService).findUserByUserName("shiv");
        verify(authorityService, times(1)).findUserByUserName("shiv");

    }

    @Test
    void saveUserTest(){

        User user=new User("shiv","shiv123",1);
        user.setRole("User");
        UserDTO userDTO=new UserDTO("shiv","shiv123","User");
        Authorities authority=new Authorities("shiv","shiv123");
        authority.setUser(user);

        User user1=new User();
        user1.setUserName("not found");

        Mockito.when(userMapper.convertToUser(userDTO)).thenReturn(user);
        Mockito.when(authorityService.findUserByUserName("shiv")).thenReturn(user1);
        when(authorityService.addUser(user)).thenReturn(authority);
        when(userMapper.convertToUserDTOFromAuthority(authority)).thenReturn(userDTO);

        userController.saveUser(userDTO);

        verify(authorityService).addUser(user);
    }

}