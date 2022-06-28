package com.example.bookstoreapplication.controller;

import static org.mockito.Mockito.*;

import com.example.bookstoreapplication.dto.BookDTO;
import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.mapper.BookMapper;
import com.example.bookstoreapplication.service.AuthorService;
import com.example.bookstoreapplication.service.CategoryService;
import com.example.bookstoreapplication.service.impl.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    BookServiceImpl bookService;

    @Mock
    AuthorService authorService;

    @Mock
    CategoryService categoryService;

    @InjectMocks
    BookController bookController;

    @Mock
    BookMapper bookMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getBookByIdTest() throws Exception {
        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);
        BookDTO BookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        when(bookService.findBookById(1)).thenReturn(bookOptional);
        mockMvc.perform(MockMvcRequestBuilders.get("/books/1").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(BookDto))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).findBookById(1);
        verify(bookService, times(1)).findBookById(1);
    }

    @Test
    void getBookTest() throws Exception{
        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);
        Author author1 = new Author(1,"Arunav Gupta");
        Author author2 = new Author(2,"Robin Sharma");
        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);

        book.setAuthor(authorList);
        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        List<BookDTO> bookDtoList = bookMapper.toBookDtoList(bookList);

        getAllBookTest(bookList, bookDtoList);

        getBookByCategoryTest(bookList, bookDtoList);

        getBookByAuthor(bookList, bookDtoList);

    }

    private void getBookByAuthor(List<Book> bookList, List<BookDTO> bookDtoList) throws Exception {
        when(bookService.getBooksByAuthor("Arunav Gupta")).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/books/author?author = Arunav Gupta").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(bookDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).getBooksByAuthor("Arunav Gupta");
        verify(bookService,times(1)).getBooksByAuthor("Arunav Gupta");
    }

    private void getBookByCategoryTest(List<Book> bookList, List<BookDTO> bookDtoList) throws Exception {
        when(bookService.getBooksByCategory("Educational")).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/books/category?category = Educational").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(bookDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).getBooksByCategory("Educational");
        verify(bookService,times(1)).getBooksByCategory("Educational");
    }

    private void getAllBookTest(List<Book> bookList, List<BookDTO> bookDtoList) throws Exception {
        when(bookService.findAllBooks()).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/books/").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(bookDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).findAllBooks();
        verify(bookService,times(1)).findAllBooks();
    }

    @Test
    void checkBookIdTest(){

        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);
        Optional<Book> bookOptional = Optional.of(book);

        when(bookService.findBookById(1)).thenReturn(bookOptional);
        bookController.checkBookId(1);

        verify(bookService).findBookById(1);
        verify(bookService,times(1)).findBookById(1);

    }

    @Test
    void deleteBookTest(){
        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);

        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        Mockito.doNothing().when(bookService).deleteBookById(1);
        Mockito.when(bookService.findBookById(1)).thenReturn(bookOptional);

        Assertions.assertEquals(" book with bookId :1 deleted.",bookController.deleteBookById(1));
        verify(bookService).deleteBookById(1);
        verify(bookService, times(1)).deleteBookById(1);

    }

    @Test
    void updateBookTest(){

        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);

        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        Mockito.when(bookMapper.convertToBook(bookDto)).thenReturn(book);
        Mockito.when(bookService.findBookById(1)).thenReturn(bookOptional);
        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        Mockito.when(bookMapper.convertToBookDTO(book)).thenReturn(bookDto);

        Assertions.assertEquals(bookDto,bookController.updateBook(bookDto));

        verify(bookService).saveBook(book);
        verify(bookService, times(1)).saveBook(book);

    }

    @Test
    void saveBookTest(){

        Book book = new Book(1,"Discrete Mathematics",450.00, "Covered all static problems", 4.2, null,null);
        Author author1 = new Author(1,"James Clear");
        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        book.setAuthor(authorList);
        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        Mockito.when(bookMapper.convertToBook(bookDto)).thenReturn(book);
        when(authorService.saveAuthor(author1)).thenReturn(author1);
        when(bookService.saveBook(book)).thenReturn(book);
        when(bookMapper.convertToBookDTO(book)).thenReturn(bookDto);

        Assertions.assertEquals(bookDto, bookController. saveBook(bookDto));

        verify(bookService).saveBook(book);
        verify(bookService, times(1)).saveBook(book);

    }
}
