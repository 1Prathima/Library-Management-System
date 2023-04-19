package com.example.Library.Management.System.entity;

import com.example.Library.Management.System.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String mobNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Department department;

    //we create birectional relationship in parent class so that whatever CRUD operations are performed on parent will be automatically performed on child due to cascade

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)  //mapped to student variable
    Card card;

}
