package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.DTO.RequestDto.BookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.BookResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.repository.AuthorRepository;
import com.example.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;


    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {
        Author author;
        try{  //checking author exists in database or not using id
            author = authorRepository.findById(bookRequestDto.getAuthorRequestIdDto().getId()).get();
        }
        catch(Exception e){
            throw new Exception("Author does not exist");
        }

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setNumberOfPages(bookRequestDto.getNumberOfPages());
        book.setPrice(bookRequestDto.getPrice());

        author.getBooks().add(book);  //adding the book to list of books written
        book.setAuthor(author);  //if we don't set the complete author object other attributes except id become null
        authorRepository.save(author);
        return "Book added";
    }

    @Override
    public List<BookResponseDto> findBooksByAuthorId(int id) {
        Author author = authorRepository.findById(id).get();
        List<Book> books = author.getBooks();

        List<BookResponseDto> bookResponseDtos = new ArrayList<>();

        for(Book book : books){
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setTitle(book.getTitle());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setNumberOfPages(book.getNumberOfPages());
            bookResponseDto.setPrice(book.getPrice());

            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());
            authorResponseDto.setEmail(author.getEmail());
            bookResponseDto.setAuthorResponseDto(authorResponseDto);

            bookResponseDtos.add(bookResponseDto);
        }
        return bookResponseDtos;
    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        List<Author> authors = authorRepository.findAll();
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for(Author author : authors){
            List<Book> books = author.getBooks();
            for(Book book : books){
                BookResponseDto bookResponseDto = new BookResponseDto();
                bookResponseDto.setTitle(book.getTitle());
                bookResponseDto.setGenre(book.getGenre());
                bookResponseDto.setNumberOfPages(book.getNumberOfPages());
                bookResponseDto.setPrice(book.getPrice());

                AuthorResponseDto authorResponseDto = new AuthorResponseDto();
                authorResponseDto.setName(author.getName());
                authorResponseDto.setAge(author.getAge());
                authorResponseDto.setEmail(author.getEmail());
                bookResponseDto.setAuthorResponseDto(authorResponseDto);

                bookResponseDtos.add(bookResponseDto);
            }
        }
        return bookResponseDtos;
    }

    @Override
    public int findNumberOfBooksByAuthorId(int id) {
        Author author = authorRepository.findById(id).get();
        List<Book> books = author.getBooks();
        return books.size();
    }
}
