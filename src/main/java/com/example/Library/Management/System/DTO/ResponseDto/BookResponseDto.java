package com.example.Library.Management.System.DTO.ResponseDto;

import com.example.Library.Management.System.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDto {
    private String title;
    private Genre genre;
    private int numberOfPages;
    private int price;
    AuthorResponseDto authorResponseDto;
}
