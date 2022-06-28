package com.example.bookstoreapplication.exception;

import com.example.bookstoreapplication.respository.BookRepository;
import com.example.bookstoreapplication.service.BookService;
import com.example.bookstoreapplication.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestExceptionHandlerTest {

    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp(){

        bookService = new BookServiceImpl(bookRepository);
    }
    @Mock
    RestExceptionHandler restExceptionHandler;

    @Test
    void exceptionHandler() {
        ErrorResponse error=new ErrorResponse("Book with given Id does not exist",12345, HttpStatus.NOT_FOUND.value());
        BookNotFoundException bookNotFoundException=new BookNotFoundException("Book with given Id does not exist");
        ResponseEntity<ErrorResponse> badRequest=new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

        Mockito.when(restExceptionHandler.exceptionHandler(bookNotFoundException)).thenReturn(badRequest);
        restExceptionHandler.exceptionHandler(bookNotFoundException);
        Mockito.verify(restExceptionHandler).exceptionHandler(bookNotFoundException);

    }
}

