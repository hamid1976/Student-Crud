package com.student.student.dao;

import org.springframework.data.repository.CrudRepository;

import com.student.student.entities.Student;

public interface StudentDao  extends CrudRepository<Student,Integer>{

    public Student findById(int id);
    
}
