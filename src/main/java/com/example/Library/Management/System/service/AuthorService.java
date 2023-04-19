package com.example.Library.Management.System.service;

import com.example.Library.Management.System.DTO.RequestDto.AuthorRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateAuthorRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.entity.Book;

import java.util.List;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);
    public AuthorResponseDto getAuthorByEmail(String email);
    public String deleteAuthorById(int id);
    public String updateAuthorById(UpdateAuthorRequestDto updateAuthorRequestDto);
    public AuthorResponseDto findAuthorById(int id);
    public List<AuthorResponseDto> findAllAuthors();
}
