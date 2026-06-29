package com.vortex.crudify.repository;

import com.vortex.crudify.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq) {
        // save to DB
        System.out.println("Inside Student Repository");
        System.out.println("Exiting Student Repository");

        Student s1 = new Student();
        s1.setName("Aditya");
        s1.setAge(30);
        s1.setEmail("aditya@gmail.com");
        s1.setRollNo(254);
        s1.setSubject("Spring");

        return s1;
    }
}
