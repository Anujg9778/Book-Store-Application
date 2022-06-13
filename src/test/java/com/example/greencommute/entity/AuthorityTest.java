package com.example.greencommute.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorityTest {

    Authority authority=new Authority("shiv","user");

    @Test
    public void authorityEntityTest(){

        assertEquals("shiv",authority.getUserName());
        assertEquals("user",authority.getAuthority());

        Authority authority1=new Authority();
        authority1.setUserName("shiv");
        authority1.setAuthority("admin");
        authority1.setUser(null);

        assertEquals("shiv",authority1.getUserName());
        assertEquals("admin",authority1.getAuthority());
        assertNull(authority1.getUser());
    }
}