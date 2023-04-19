package com.example.Library.Management.System.entity;

import com.example.Library.Management.System.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int numberOfPages;
    private int price;
    private boolean isIssued;
    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    Card card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>(); //when you are registering a book for the first time it does not have any transaction
}
