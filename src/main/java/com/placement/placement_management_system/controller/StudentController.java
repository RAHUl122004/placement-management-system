package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.placement_management_system.entity.Student;
import com.placement.placement_management_system.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
}
