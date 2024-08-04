package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<Student> findAllStudents(){
        return List.of(
                new Student("Maryem","jerad",22,"m@m.m"),
                new Student("Souhir","jerad",22,"m@m.m")
        );
    }
}
