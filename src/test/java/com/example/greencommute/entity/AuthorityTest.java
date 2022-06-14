package com.example.greencommute.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorityTest {

    Authorities authority=new Authorities("shiv","user");

    @Test
    void authorityEntityTest(){

        assertEquals("shiv",authority.getUserName());
        assertEquals("user",authority.getAuthority());

        Authorities authority1=new Authorities();
        authority1.setUserName("shiv");
        authority1.setAuthority("admin");
        authority1.setUser(null);

        assertEquals("shiv",authority1.getUserName());
        assertEquals("admin",authority1.getAuthority());
        assertNull(authority1.getUser());
    }
}