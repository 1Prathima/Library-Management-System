package com.example.Library.Management.System.service.impl;

import com.example.Library.Management.System.DTO.RequestDto.StudentRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library.Management.System.DTO.RequestDto.UpdateStudentRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.CardResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.StudentResponseDto;
import com.example.Library.Management.System.DTO.ResponseDto.UpdateStudentMobResponseDto;
import com.example.Library.Management.System.entity.Card;
import com.example.Library.Management.System.entity.Student;
import com.example.Library.Management.System.enums.CardStatus;
import com.example.Library.Management.System.exceptions.StudentNotFoundException;
import com.example.Library.Management.System.repository.StudentRepository;
import com.example.Library.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setEmail(studentRequestDto.getEmail());

        Card card = new Card();  //card information is not taken from the student so we have to generate it in the backend
        card.setStatus(CardStatus.ACTIVATED);  //if not generated card will be null
        card.setValidTill("2024-10-01");
        card.setStudent(student);

        student.setCard(card);  //student object ready
        studentRepository.save(student); //card will also be saved automatically due to cascade that's why we create birectional relationship
        return "Student added";
    }

    @Override
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            //prepare a responseDto
            UpdateStudentMobResponseDto updateStudentMobResponseDto = new UpdateStudentMobResponseDto();
            updateStudentMobResponseDto.setName(updatedStudent.getName());
            updateStudentMobResponseDto.setMobNo(updatedStudent.getMobNo());

            return updateStudentMobResponseDto;
        }
        catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    @Override
    public StudentResponseDto updateStudentById(UpdateStudentRequestDto updateStudentRequestDto) {
        Student student = studentRepository.findById(updateStudentRequestDto.getId()).get();
        student.setName(updateStudentRequestDto.getName());
        student.setAge(updateStudentRequestDto.getAge());
        student.setMobNo(updateStudentRequestDto.getMobNo());
        student.setDepartment(updateStudentRequestDto.getDepartment());
        studentRepository.save(student);


        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setEmail(student.getEmail());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setStatus(student.getCard().getStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }

    @Override
    public StudentResponseDto findStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setEmail(student.getEmail());

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setStatus(student.getCard().getStatus());
        cardResponseDto.setValidTill(student.getCard().getValidTill());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }

    @Override
    public List<StudentResponseDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for(Student student : students){
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setDepartment(student.getDepartment());
            studentResponseDto.setEmail(student.getEmail());

            CardResponseDto cardResponseDto = new CardResponseDto();
            cardResponseDto.setId(student.getCard().getId());
            cardResponseDto.setIssueDate(student.getCard().getIssueDate());
            cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
            cardResponseDto.setStatus(student.getCard().getStatus());
            cardResponseDto.setValidTill(student.getCard().getValidTill());

            studentResponseDto.setCardResponseDto(cardResponseDto);
            studentResponseDtos.add(studentResponseDto);
        }
        return studentResponseDtos;
    }
}
