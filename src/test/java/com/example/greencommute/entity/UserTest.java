package com.example.greencommute.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Test
    void userEntityTest(){

        User user=new User("john","john123",1);
        assertEquals("john",user.getUserName());
        assertEquals("john123",user.getPassword());
        assertEquals(1,user.getEnabled());

        User user1=new User();
        user1.setUserName("carl");
        user1.setPassword("carl123");
        user1.setEnabled(0);

        assertEquals("carl",user1.getUserName());
        assertEquals("carl123",user1.getPassword());
        assertEquals(0,user1.getEnabled());
    }

}