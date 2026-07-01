package com.vortex.crudify.service;

import com.vortex.crudify.entity.Student;
import com.vortex.crudify.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isPresent()) return studentResp.get();
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findByAndDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) return null;

        Student studentToSave =  existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()) return false;
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;

    }
}
