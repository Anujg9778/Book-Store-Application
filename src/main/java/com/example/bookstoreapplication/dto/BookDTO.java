package com.example.greencommute.dto;


import com.example.greencommute.entity.Author;
import com.example.greencommute.entity.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int bookId;
    private String description;
    private String bookName;
    private double bookPrice;
    private double bookRating;
    private List<Author> author;
    private List<Category> category;

}
