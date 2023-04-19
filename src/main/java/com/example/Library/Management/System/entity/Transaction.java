package com.example.Library.Management.System.entity;

import com.example.Library.Management.System.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssueOperation;  //true: if the transaction is for issuing a book & false: for returning a book
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
