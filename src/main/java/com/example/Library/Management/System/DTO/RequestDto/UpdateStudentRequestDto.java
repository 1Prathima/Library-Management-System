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
public class UpdateStudentRequestDto {
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private Department department;
}
