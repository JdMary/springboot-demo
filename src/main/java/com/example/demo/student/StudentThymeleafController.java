package com.example.demo.student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf-student")
public class StudentThymeleafController {

    private final StudentService service;

    public StudentThymeleafController(@Qualifier("DBStudentService") StudentService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(Student student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{email}")
    public String showEditStudentForm(@PathVariable("email") String email, Model model) {
        Student student = service.findByEmail(email);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/edit/{email}")
    public String editStudent(Student student) {
        service.update(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{email}")
    public String deleteStudent(@PathVariable("email") String email) {
        service.delete(email);
        return "redirect:/students";
    }

    @GetMapping
    public String viewStudents(Model model) {
        List<Student> students = service.findAllStudents();
        model.addAttribute("students", students);
        return "index";
    }
}
