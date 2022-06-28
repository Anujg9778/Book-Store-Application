package com.example.bookstoreapplication.mapper;

import com.example.bookstoreapplication.dto.BookDTO;
import com.example.bookstoreapplication.entity.Book;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    ModelMapper modelMapper;

    public BookMapper(ModelMapper mapper){
        this.modelMapper=mapper;
    }

    public BookDTO convertToBookDTO(Book theBook){
        return modelMapper.map(theBook,BookDTO.class);
    }

    public Book convertToBook(BookDTO bookDTO){
        return modelMapper.map(bookDTO,Book.class);
    }

    public List<BookDTO> toBookDtoList(List<Book> booksList){
        return booksList.stream().map(this::convertToBookDTO).collect(Collectors.toList());
    }
}

