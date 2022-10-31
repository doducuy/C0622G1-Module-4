package com.demo.service;

import com.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student>findAll();
    Student findById(int id);
    void save(Student student);
}
