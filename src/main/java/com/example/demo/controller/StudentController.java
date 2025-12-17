
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
@CrossOrigin(origins = "*")

@RestController

public class StudentController{
    @Autowired
    StudentService ser;

    @PostMapping("/PostStudent")
    public Student postStd(@RequestBody Student st){
        return ser.insertStudent(st);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return ser.getAllStudent(st);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> get(@PathVariable Long id){
        return ser.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody Student newStudent){
        Optional<Student> student=ser.getOneStudent(id);
        if(student.iSPresent()){
            newStudent.setId(id);
            ser.insertStudent(newStudent);
            return "Updated Success";
        }
        return "id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable Long id ){
        Option<Student> student = ser.getOneStudent(id);
        if(student.iSPresent()){
            ser.deleteStudent(id);
            return "Deleted Success";
        }
        return "Id Not Found";
    }
}