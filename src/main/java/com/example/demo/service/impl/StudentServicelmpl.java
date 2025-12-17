package com.example.demo.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

@service
public class StudentServiceImpl implements StudentService{
    @Autowired
    Studentrepo strepo;
    @Override

    public Student insertStudent(Student st){
        return strepo.save(st);
    }   

    @Override
    public List<Student> getAllStudents(){
        return strepo.findAll(st);
    }

    @Override
    public Optional<Student> getOneStudent(Long id){
        return strepo.findById(id);
    }

    @Override
    public void deleteStudent(Long id){
        return strepo.deleteById(id);
    }


}
