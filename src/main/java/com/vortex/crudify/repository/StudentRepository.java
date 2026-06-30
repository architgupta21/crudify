package com.vortex.crudify.repository;

import com.vortex.crudify.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}