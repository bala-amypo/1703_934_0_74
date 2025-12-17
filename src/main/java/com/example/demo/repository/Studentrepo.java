package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaReporitory;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;


@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {
    
}
