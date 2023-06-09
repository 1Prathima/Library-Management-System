package com.example.Library.Management.System.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateAuthorRequestDto {
    private int id;
    private String name;
    private int age;
    private String email;
}
