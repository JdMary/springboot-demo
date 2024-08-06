package com.example.demo.student;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class DBStudentService implements StudentService{
    private final StudentRepository repository;

    public DBStudentService(StudentRepository rep) {
        this.repository = rep;
    }


    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student save(Student s) {
        return repository.save(s);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void delete(String email) {
        repository.delete(findByEmail(email));
    }

    @Override
    public Student update(Student s) {
        return repository.save(s);
    }
}
