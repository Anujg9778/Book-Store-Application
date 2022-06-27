package com.example.greencommute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

    @Column(name="description")
    private String description;

    @Column(name="name")
    private String bookName;

    @Column(name="price")
    private double bookPrice;

    @Column(name="rating")
    private String bookRating;

    @ManyToMany(fetch = FetchType.LAZY,cascade =CascadeType.MERGE)
    @JoinTable(
            name="book_author",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private List<Author> author;

    @ManyToMany(fetch = FetchType.LAZY,cascade =CascadeType.MERGE)
    @JoinTable(
            name="book_category",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private List<Category> category;

}
