package com.example.greencommute.mapper;

import com.example.bookstoreapplication.dto.BookDTO;
import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.mapper.BookMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookMapperTest {

    BookMapper bookMapper;

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    void setUp(){
        bookMapper=new BookMapper(modelMapper);
    }

    @Test
    void toBookDtoTest() {
        Book book = new Book(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);
        BookDTO bookDto = new BookDTO(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);

        Mockito.when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDto);
        Assertions.assertEquals(bookDto,bookMapper.convertToBookDTO(book));
        Mockito.verify(modelMapper).map(book,BookDTO.class);
    }

    @Test
    void toJobTest() {
        Book book = new Book(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);
        BookDTO bookDto = new BookDTO(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);

        Mockito.when(modelMapper.map(bookDto,Book.class)).thenReturn(book);
        Assertions.assertEquals(book,bookMapper.convertToBook(bookDto));
        Mockito.verify(modelMapper).map(bookDto,Book.class);
    }

    @Test
    void toBookDtoListTest() {

        Book book = new Book(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);
        BookDTO bookDto = new BookDTO(1,"software engineer","Ant and Grasshopper", 420.80, 4.8,null,null);
        List<Book> bookList = new ArrayList<>();
        List<BookDTO> bookDtoList = new ArrayList<>();
        bookList.add(book);
        bookDtoList.add(bookDto);

        Mockito.when(modelMapper.map(book,BookDTO.class)).thenReturn(bookDto);
        Assertions.assertEquals(bookDtoList,bookMapper.toBookDtoList(bookList));
        Mockito.verify(modelMapper).map(book,BookDTO.class);
    }
}
