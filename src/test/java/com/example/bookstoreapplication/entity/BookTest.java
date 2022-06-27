package com.example.greencommute.entity;

import com.example.bookstoreapplication.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    Book book = new Book(1,"Software  Development Engineer","Concept of cpp", 450.00, 4.5, null, null);

    @Test
    void jobEntityTest(){

        assertEquals(1,book.getBookId());
        assertEquals("Software Engineer",book.getBookName());
        assertEquals("4.5",book.getBookRating());
        assertNull(book.getAuthor());

        Book book1=new Book();
        book1.setBookId(2);
        book1.setBookName("Software Engineer");
        book1.setBookPrice(450);
        book1.setBookRating(4.5);
        book1.setAuthor(null);
        book1.setCategory(null);

        assertEquals(2,book1.getBookId());
        assertEquals("Software Engineer",book1.getBookName());
        assertEquals("Mumbai",book1.getBookPrice());
        assertNull(book1.getAuthor());
    }

}