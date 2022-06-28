package com.example.bookstoreapplication.service.impl;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.respository.AuthorRepository;
import com.example.bookstoreapplication.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorServiceImplTest {

    @Mock
    AuthorRepository authorRepository;

    private AuthorService authorService;

    @BeforeEach
    void initUseCase(){
        authorService = new AuthorServiceImpl(authorRepository);
    }


    @Test
    void findAuthor() {
        Optional<Author> author=Optional.of(new Author(1,"Arunav Gupta"));

        Mockito.when(authorRepository.findById(1)).thenReturn(author);
        Assertions.assertEquals(author, authorService.findAuthorById(1));
        Mockito.verify(authorRepository).findById(1);

    }

    @Test
    void saveAuthor() {
        Author author=new Author(1,"Arunav Gupta");

        Mockito.when(authorRepository.save(author)).thenReturn(author);
        Assertions.assertEquals(author, authorService.saveAuthor(author));
        Mockito.verify(authorRepository).save(author);

    }
}