package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.StudentResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.entity.Student;
import com.example.Library.Management.System.exceptions.StudentNotFoundException;
import com.example.Library.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("/updateMobNo")
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id") int id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/update")
    public StudentResponseDto updateStudentById(@RequestBody UpdateStudentRequestDto updateStudentRequestDto){
        return studentService.updateStudentById(updateStudentRequestDto);
    }

    @GetMapping("/getStudent")
    public StudentResponseDto findStudentById(@RequestParam("id") int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/getAllStudents")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }
}
