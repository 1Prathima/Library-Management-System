package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.DTO.RequestDto.BookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.BookResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
        return bookService.addBook(bookRequestDto);
    }

    @GetMapping("/getBooksByAuthorId")
    public List<BookResponseDto> findBooksByAuthorId(@RequestParam int id){
        return bookService.findBooksByAuthorId(id);
    }

    @GetMapping("/getAllBooks")
    public List<BookResponseDto> findAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/getNumberOfBooksByAuthorId")
    public int findNumberOfBooksByAuthorId(@RequestParam int id){
        return bookService.findNumberOfBooksByAuthorId(id);
    }
}
