package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public String addStudent(@RequestBody Student s) {
        service.addStudent(s);
        return "Student added successfully";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PutMapping("/{id}/{marks}")
    public String updateMarks(@PathVariable int id,
                              @PathVariable int marks) {
        service.updateMarks(id, marks);
        return "Marks updated";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted";
    }
}
