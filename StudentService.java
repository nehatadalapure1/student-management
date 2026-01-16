package com.example.student_management.service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void addStudent(Student s) {
        repository.addStudent(s);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public void updateMarks(int id, int marks) {
        repository.updateMarks(id, marks);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}
