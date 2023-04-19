package com.example.Library.Management.System.DTO.ResponseDto;

import com.example.Library.Management.System.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private String email;
    private Department department;
    CardResponseDto cardResponseDto;
}
