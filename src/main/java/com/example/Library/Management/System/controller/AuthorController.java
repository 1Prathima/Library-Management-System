package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.DTO.RequestDto.AuthorRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateAuthorRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/getByEmail")
    public AuthorResponseDto getAuthorByEmail(@RequestParam String email){
        return authorService.getAuthorByEmail(email);
    }

    @DeleteMapping("/delete")
    public String deleteAuthorById(@RequestParam int id){
        return authorService.deleteAuthorById(id);
    }

    @PutMapping("/update")
    public  String updateAuthorById(@RequestBody UpdateAuthorRequestDto updateAuthorRequestDto){
        return authorService.updateAuthorById(updateAuthorRequestDto);
    }

    @GetMapping("/getAuthorById")
    public AuthorResponseDto findAuthorById(@RequestParam int id){
        return authorService.findAuthorById(id);
    }

    @GetMapping("/getAllAuthors")
    public List<AuthorResponseDto> findAllAuthors(){
        return authorService.findAllAuthors();
    }
}
