package com.example.Library.Management.System.entity;

import com.example.Library.Management.System.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private String validTill;

    @OneToOne   //creating relationship card->student
    @JoinColumn   //creates column for primary key
    Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();  //when a person is alocated a new card there are no transactions

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();  //when a person is allocated a new card there are no books isuued

}
