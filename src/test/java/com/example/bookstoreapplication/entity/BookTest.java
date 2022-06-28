package com.example.bookstoreapplication.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);

    @Test
    void bookEntityTest(){

        assertEquals(1,book.getBookId());
        assertEquals("Discrete Mathematics",book.getBookName());
        assertEquals("4.2",book.getBookRating());
        assertNull(book.getAuthor());

        Book book1=new Book();
        book1.setBookId(2);
        book1.setBookName("Discrete Mathematics");
        book1.setBookPrice(450);
        book1.setBookRating(4.2);
        book1.setAuthor(null);
        book1.setCategory(null);

        assertEquals(2,book1.getBookId());
        assertEquals("Discrete Mathematics",book1.getBookName());
        assertEquals("450",book1.getBookPrice());
        assertNull(book1.getAuthor());
    }

}