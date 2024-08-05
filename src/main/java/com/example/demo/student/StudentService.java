package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
     List<Student> findAllStudents();
     Student save(Student s);
     Student findByEmail(String email);
     void delete(String email);
     Student update(Student s);
}
