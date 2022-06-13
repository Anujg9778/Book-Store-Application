package com.example.greencommute.service.impl;

import com.example.greencommute.entity.User;
import com.example.greencommute.respository.UserRepository;
import com.example.greencommute.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService=new UserServiceImpl(userRepository);
    }

    @Test
    void findUserByUserNameTest(){
        User user=new User("john","john123",1);

        Mockito.when(userRepository.getUserByUserName("john")).thenReturn(user);
        assertEquals(userService.findUserByUserName("john"),user);
        Mockito.verify(userRepository).getUserByUserName("john");

    }

    @Test
    void deleteUserByUserNameTest(){

        User user=new User("john","john123",1);

        Mockito.doNothing().when(userRepository).deleteUserByUserName("john");
        userService.deleteUser("john");
        Mockito.verify(userRepository).deleteUserByUserName("john");
    }

    @Test
    void saveUserTest(){

        User user=new User("john","john123",1);

        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(userService.saveUser(user),user);
        Mockito.verify(userRepository).save(user);
    }

}
