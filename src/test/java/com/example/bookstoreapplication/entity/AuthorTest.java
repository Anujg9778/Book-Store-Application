package com.example.bookstoreapplication.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorTest {

    Author author=new Author(1,"Paul Coehlo");

    @Test
    void authorEntityTest(){

        assertEquals(1,author.getAuthorId());
        assertEquals("Paul Coehlo",author.getAuthorName());

        Author author1=new Author();
        author1.setAuthorId(2);
        author1.setAuthorName("spring");

        assertEquals(2,author1.getAuthorId());
        assertEquals("spring",author1.getAuthorName());
    }

}