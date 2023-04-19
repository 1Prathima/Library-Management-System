package com.example.Library.Management.System.service;

import com.example.Library.Management.System.DTO.RequestDto.BookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.BookResponseDto;
import com.example.Library.Management.System.entity.Book;

import java.util.List;

public interface BookService {
    public String addBook(BookRequestDto bookRequestDto) throws Exception;
    public List<BookResponseDto> findBooksByAuthorId(int id);
    public List<BookResponseDto> findAllBooks();
    public int findNumberOfBooksByAuthorId(int id);
}
