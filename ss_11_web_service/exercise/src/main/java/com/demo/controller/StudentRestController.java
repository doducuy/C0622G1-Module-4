package com.demo.controller;

import com.demo.dto.StudentDto;
import com.demo.model.Student;
import com.demo.service.IStudentService;
import com.demo.service.impl.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/v1")
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getListStudent(){
        List<Student> studentList = studentService.findAll();
        if(studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        Student student =new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.save(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody StudentDto studentDto){
        Student currentStudent = studentService.findById(id);
        if(currentStudent==null){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        currentStudent.setName(studentDto.getName());
//        currentStudent.setGender(studentDto.getGender());
        studentDto.setId(id);
        BeanUtils.copyProperties(studentDto,currentStudent);
        studentService.save(currentStudent);
        return new ResponseEntity<>(currentStudent,HttpStatus.OK);
    }
}
