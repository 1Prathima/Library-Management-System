package com.example.Library.Management.System.service;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.StudentResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.entity.Student;
import com.example.Library.Management.System.exceptions.StudentNotFoundException;

import java.util.List;

//easier to know all the methods that's why service interface
public interface StudentService {
     public String addStudent(StudentRequestDto studentRequestDto);

     public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;
     public String deleteStudentById(int id);
     public StudentResponseDto updateStudentById(UpdateStudentRequestDto updateStudentRequestDto);
     public StudentResponseDto findStudentById(int id);
     public List<StudentResponseDto> findAllStudents();
}
