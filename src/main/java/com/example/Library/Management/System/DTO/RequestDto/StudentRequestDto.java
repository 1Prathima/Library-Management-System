package com.example.Library.Management.System.DTO.RequestDto;

import com.example.Library.Management.System.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    private String name;
    private int age;
    private String mobNo;
    private String email;
    private Department department;
}
