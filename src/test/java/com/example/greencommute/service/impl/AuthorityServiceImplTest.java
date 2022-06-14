package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Authorities;
import com.example.greencommute.entity.User;
import com.example.greencommute.respository.AuthorityRepository;
import com.example.greencommute.service.AuthorityService;
import com.example.greencommute.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorityServiceImplTest {

    @Mock
    UserService userService;

    @Mock
    AuthorityRepository authorityRepository;

    private AuthorityService authorityService;

    @BeforeEach
    void setUp(){
        authorityService=new AuthorityServiceImpl(userService,authorityRepository);
    }



    @Test
    void userByUserNameTest(){

        User user=new User("shiv","shiv123",1);
        Authorities authority=new Authorities();
        authority.setUserName("shiv");
        authority.setAuthority("ADMIN");
        authority.setUser(user);

        Mockito.when(authorityRepository.findById("shiv")).thenReturn(Optional.of(authority));
        assertTrue(Optional.of(authority).isPresent());
        authorityService.findUserByUserName("shiv");

        Mockito.verify(authorityRepository).findById("shiv");

    }

    @Test
    void addUserTest(){
        User user=new User("shiv","shiv123",1);
        user.setRole("Admin");
        Authorities authority=new Authorities();
        authority.setUserName(user.getUserName());
        authority.setAuthority(user.getRole());
        authority.setUser(user);

        Mockito.when(userService.saveUser(user)).thenReturn(user);
        Mockito.when(authorityRepository.save(authority)).thenReturn(authority);
        authorityService.addUser(user);

        assertEquals(user.getUserName(),authority.getUserName());
        assertEquals(user.getRole(),authority.getAuthority());

    }


}