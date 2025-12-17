package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @Autowired
    private StudentService ser;

    @PostMapping("/postStudent")
    public Student postStd(@RequestBody Student st) {
        return ser.insertStudent(st);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return ser.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<Student> get(@PathVariable Long id) {
        return ser.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody Student newStudent) {
        Optional<Student> student = ser.getOneStudent(id);
        if (student.isPresent()) {
            newStudent.setId(id);
            ser.insertStudent(newStudent);
            return "Updated Success";
        }
        return "Id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = ser.getOneStudent(id);
        if (student.isPresent()) {
            ser.deleteStudent(id);
            return "Deleted Success";
        }
        return "Id Not Found";
    }
}
