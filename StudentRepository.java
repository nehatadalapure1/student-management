package com.example.student_management.repository;

import com.example.student_management.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent(Student s) {
        String sql = "INSERT INTO student VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getMarks());
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("marks")
                )
        );
    }

    public void updateMarks(int id, int marks) {
        String sql = "UPDATE student SET marks=? WHERE id=?";
        jdbcTemplate.update(sql, marks, id);
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
