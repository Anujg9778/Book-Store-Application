package com.example.bookstoreapplication.service.impl;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.entity.Category;
import com.example.bookstoreapplication.respository.BookRepository;
import com.example.bookstoreapplication.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {

    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void initUseCase(){
        bookService = new BookServiceImpl(bookRepository);
    }


    @Test
    void findAllBookTest() {

        Book book1=new Book(0,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);
        Book book2=new Book(0,"C shark developer Guide",290.00,"Akash Agarwal", 3.8,null,null);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        Mockito.when(bookRepository.findAll()).thenReturn(bookList);
        Assertions.assertEquals(bookList, bookService.findAllBooks());
        Mockito.verify(bookRepository).findAll();
    }

    @Test
    void findBookByIdTest() {
        Book book = new Book(1,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);
        Optional<Book> bookOptional = Optional.of(book);
        Mockito.when(bookRepository.findById(1)).thenReturn(bookOptional);
        Assertions.assertEquals(bookOptional, bookService.findBookById(1));
        Mockito.verify(bookRepository).findById(1);
    }

    @Test
    void deleteBookTest() {

        Book book = new Book(1,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);

        doNothing().when(bookRepository).deleteById(1);
        bookService.deleteBookById(1);
        Mockito.verify(bookRepository).deleteById(1);

    }

    @Test
    void saveBookTest() {
        Book book = new Book(1,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);

        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertEquals(book, bookService.saveBook(book));
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void getBooksByAuthorTest() {

        List<Book> bookList = new ArrayList<>();

        Author author=new Author(1,"Arunav Gupta");
        List<Author> authors=new ArrayList<>();
        authors.add(author);

        Book book = new Book(1,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);
        bookList.add(book);

        Mockito.when(bookRepository.getBookByAuthor("Arunav Gupta")).thenReturn(bookList);
        Assertions.assertEquals(bookList, bookService.getBooksByAuthor("Arunav Gupta"));
        Mockito.verify(bookRepository).getBookByAuthor("Arunav Gupta");

    }

    @Test
    void getBooksByCategoryTest() {

        List<Book> bookList = new ArrayList<>();

        Category category=new Category(1,"Educational");
        List<Category> categories=new ArrayList<>();
        categories.add(category);

        Book book = new Book(1,"System Engineer Guide",300.00,"Arunav Gupta",  4.1, null,null);
        bookList.add(book);

        Mockito.when(bookRepository.getBookByCategory("Educational")).thenReturn(bookList);
        Assertions.assertEquals(bookList, bookService.getBooksByCategory("Educational"));
        Mockito.verify(bookRepository).getBookByCategory("Educational");

    }
}