package com.example.bookstoreapplication.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BookDTOTest {

    BookDTO bookDTO=new BookDTO(1,"Twilight Saga", 250, "Robert Madson Story",4.2,null,null);

    @Test
    void bookDtoEntityTest(){

        Assertions.assertEquals(1, bookDTO.getBookId());
        Assertions.assertEquals("Twilight Saga", bookDTO.getBookName());
        Assertions.assertEquals("4.2",bookDTO.getBookRating());
        Assertions.assertNull(bookDTO.getCategory());
        Assertions.assertNull(bookDTO.getAuthor());

        BookDTO bookDTO1=new BookDTO();
        bookDTO1.setBookId(2);
        bookDTO1.setBookName("Atomic Habits");
        bookDTO1.setBookRating(4.2);
        bookDTO1.setBookPrice(420);
        bookDTO1.setAuthor(null);
        bookDTO1.setCategory(null);

        Assertions.assertEquals(2, bookDTO1.getBookId());
        Assertions.assertEquals("Atomic Habits", bookDTO1.getBookName());
        Assertions.assertEquals(4.2,bookDTO1.getBookRating());
        Assertions.assertEquals(420,bookDTO1.getBookRating());
        Assertions.assertNull(bookDTO1.getAuthor());
        Assertions.assertNull(bookDTO1.getCategory());

    }


}