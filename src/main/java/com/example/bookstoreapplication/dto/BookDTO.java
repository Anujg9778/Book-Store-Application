package com.example.bookstoreapplication.dto;


import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.entity.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int bookId;
    private String bookName;
    private double bookPrice;
    private String description;
    private double bookRating;
    private List<Author> author;
    private List<Category> category;

}
