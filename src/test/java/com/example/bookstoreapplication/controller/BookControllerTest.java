package com.example.greencommute.controller;


import static org.mockito.Mockito.*;


import com.example.bookstoreapplication.controller.BookController;
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
        Book book = new Book(1, "Story of Sphered Boy", "Alchemist", 450.00, 4.54, null, null);
        BookDTO BookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        when(bookService.findBookById(1)).thenReturn(bookOptional);
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs/1").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(BookDto))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).findBookById(1);
        verify(bookService, times(1)).findBookById(1);
    }

    @Test
    void getBookTest() throws Exception{
        Book book = new Book(1,"A sphered Boy","The Alchemist",350, 4.5, null, null);
        Author author1 = new Author(1,"Paul Coehlo");
        Author author2 = new Author(2,"Robin Sharma");
        List<Author> bookList = new ArrayList<>();
        bookList.add(author1);
        bookList.add(author2);

        book.setAuthor(bookList);
        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        List<BookDTO> bookDtoList = bookMapper.toBookDtoList(bookList);

        getAllBookTest(bookList, bookDtoList);

        getJobByCategoryTest(bookList, bookDtoList);

        getJobByAuthor(bookList, bookDtoList);

    }

    private void getJobBySkill(List<Book> jobsList, List<BookDTO> jobsDtoList) throws Exception {
        when(bookService.getBooksByAuthor("Paul Coehlo")).thenReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs/skills?skill=hibernate").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(jobsDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).getBooksByAuthor("Robin Sharma");
        verify(bookService,times(1)).getBooksByAuthor("James Clear");
    }

    private void getJobByLocationTest(List<Book> bookList, List<BookDTO> bookDtoList) throws Exception {
        when(bookService.getBooksByCategory("Drama")).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs/location?location=Hyderabad").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(bookDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).getBooksByCategory("Drama");
        verify(bookService,times(1)).getBooksByCategory("Literature");
    }

    private void getAllJobsTest(List<Book> bookList, List<BookDTO> bookDtoList) throws Exception {
        when(bookService.findAllBooks()).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/jobs/").
                        contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(bookDtoList))).
                andDo(MockMvcResultHandlers.print());
        verify(bookService).findAllBooks();
        verify(bookService,times(1)).findAllBooks();
    }

    @Test
    void checkJobIdTest(){

        Book book = new Book(1,"A sphered Boy","The Alchemist",350, 4.5, null, null);
        Optional<Book> bookOptional = Optional.of(book);

        when(bookService.findBookById(1)).thenReturn(bookOptional);
        bookController.checkBookId(1);

        verify(bookService).findBookById(1);
        verify(bookService,times(1)).findBookById(1);

    }

    @Test
    void deleteJobTest(){
        Book book = new Book(1,"A sphered Boy","The Alchemist",350, 4.5, null, null);

        BookDTO bookDto = bookMapper.convertToBookDTO(book);
        Optional<Book> bookOptional = Optional.of(book);

        Mockito.doNothing().when(bookService).deleteBookById(4);
        Mockito.when(bookService.findBookById(4)).thenReturn(bookOptional);

        Assertions.assertEquals(" job with jobId :4 deleted.",bookController.deleteJobById(4));
        verify(bookService).deleteBookById(4);
        verify(bookService, times(1)).deleteBookById(4);

    }

    @Test
    void updateJobTest(){

        Book book = new Book(1,"A Day with a beautiful girl", "A Girl with Basket", 300, 4.5, null,null);

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
    void saveJobTest(){

        Book book = new Book(1,"Story oh how to build good habits","Atomic Habit", 300, 4.7, "James Clear","Robin Sharma");
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
