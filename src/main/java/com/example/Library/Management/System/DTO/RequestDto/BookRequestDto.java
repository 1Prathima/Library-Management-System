package com.example.Library.Management.System.DTO.RequestDto;

import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.entity.Author;
import com.example.Library.Management.System.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;
    private Genre genre;
    private int numberOfPages;
    private int price;
    AuthorRequestIdDto authorRequestIdDto;
}
