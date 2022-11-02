package com.demo.service.impl;

import com.demo.model.Student;
import com.demo.repository.IStudentRepository;
import com.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return iStudentRepository.findById(id).orElse(new Student());
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        iStudentRepository.delete(student);
    }

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepository.findByNameContains(name);
    }
}
