package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemoryStudentService implements StudentService{

    private final InMemoryStudentDao DAO;

    public InMemoryStudentService(InMemoryStudentDao DAO) {
        this.DAO = DAO;
    }

    @Override
    public List<Student> findAllStudents() {
        return this.DAO.findAllStudents();
    }

    @Override
    public Student save(Student s) {
        return this.DAO.save(s);
    }

    @Override
    public Student findByEmail(String email) {
        return this.DAO.findByEmail(email);
    }

    @Override
    public void delete(String email) {
    this.DAO.delete(email);
    }

    @Override
    public Student update(Student s) {
        return this.DAO.update(s);
    }
}
