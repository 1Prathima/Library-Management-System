package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.DTO.RequestDto.AuthorRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateAuthorRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.repository.AuthorRepository;
import com.example.Library.Management.System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);
        return "Author added";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {
        Author author = authorRepository.findByEmail(email);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setEmail(author.getEmail());

        return authorResponseDto;
    }

    @Override
    public String deleteAuthorById(int id) {
        authorRepository.deleteById(id);
        return "Author has been deleted";
    }

    @Override
    public String updateAuthorById(UpdateAuthorRequestDto updateAuthorRequestDto) {
        Author author = authorRepository.findById(updateAuthorRequestDto.getId()).get();
        author.setName(updateAuthorRequestDto.getName());
        author.setAge(updateAuthorRequestDto.getAge());
        author.setEmail(updateAuthorRequestDto.getEmail());
        authorRepository.save(author);

        return "Author updated";
    }

    @Override
    public AuthorResponseDto findAuthorById(int id) {
        Author author = authorRepository.findById(id).get();

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setEmail(author.getEmail());

        return authorResponseDto;
    }

    @Override
    public List<AuthorResponseDto> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();

        for (Author author : authors) {
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());
            authorResponseDto.setEmail(author.getEmail());

            authorResponseDtos.add(authorResponseDto);
        }
        return authorResponseDtos;
    }
}
