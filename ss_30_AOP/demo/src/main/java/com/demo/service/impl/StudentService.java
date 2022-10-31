package com.demo.service.impl;

import com.demo.model.Student;
import com.demo.repository.IStudentRepo;
import com.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepo iStudentRepo;
    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        return iStudentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }
}
