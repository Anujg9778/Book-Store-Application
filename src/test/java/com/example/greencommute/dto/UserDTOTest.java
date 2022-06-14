package com.example.greencommute.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDTOTest {

    @Test
    void userDTOTest(){

        UserDTO userDTO=new UserDTO("shiv","shiv123","Admin");

        assertEquals("shiv",userDTO.getUserName());
        assertEquals("shiv123",userDTO.getPassword());
        assertEquals("Admin",userDTO.getRole());

        UserDTO userDTO1=new UserDTO();

        userDTO1.setUserName("shiv");
        userDTO1.setPassword("shiv123");
        userDTO1.setRole("user");

        assertEquals("shiv",userDTO1.getUserName());
        assertEquals("shiv123",userDTO1.getPassword());
        assertEquals("user",userDTO1.getRole());

    }

}