package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.Card;
import com.example.Library.Management.System.entity.Transaction;
import com.example.Library.Management.System.enums.CardStatus;
import com.example.Library.Management.System.enums.TransactionStatus;
import com.example.Library.Management.System.repository.BookRepository;
import com.example.Library.Management.System.repository.CardRepository;
import com.example.Library.Management.System.repository.TransactionRepository;
import com.example.Library.Management.System.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();  //transaction always starts no matter success or fail
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{       //see if card exists or not
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!");
        }
        transaction.setCard(card);

        Book book;
        try{     //see if book exists or not
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid book id!!");
        }
        transaction.setBook(book);

        if(card.getStatus() != CardStatus.ACTIVATED){    //if the card is not active
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!");
        }

        if(book.isIssued() == true){   //if the book is already issued
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);    //check other entities and set the parameters
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getTransactionList().add(transaction);
        card.getBooksIssued().add(book);

        cardRepository.save(card); //saves card,book and transaction

        //make a response Dto
        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        issueBookResponseDto.setBookTitle(book.getTitle());

//        String text = "Congrats! "+ card.getStudent().getName() + " You have been issued the book "+ book.getTitle();
//
//        //sending mail
//        SimpleMailMessage message = new SimpleMailMessage();  //class that is used to send mails
//        message.setFrom("lisabp3571@gmail.com");
//        message.setTo(card.getStudent().getEmail());
//        message.setSubject("Hey");
//        message.setText(text);
//        emailSender.send(message);

        return issueBookResponseDto;
    }

    @Override
    public String returnBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();  //transaction always starts no matter success or fail
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(false);

        Card card;
        try{       //see if card exists or not
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!");
        }
        transaction.setCard(card);

        Book book;
        try{     //see if book exists or not
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid book id!!");
        }
        transaction.setBook(book);


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);    //check other entities and set the parameters
        book.setCard(null);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().remove(book);
        card.getTransactionList().add(transaction);

//        cardRepository.save(card); //saves card,book and transaction
        transactionRepository.save(transaction);
        return "Book returned";
    }
}
