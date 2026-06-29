package com.vortex.crudify.controller;

import com.vortex.crudify.entity.Student;
import com.vortex.crudify.service.StudentService;
import org.hibernate.annotations.Audited;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

}