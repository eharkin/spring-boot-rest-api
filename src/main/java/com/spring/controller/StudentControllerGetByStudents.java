package com.spring.controller;

import com.spring.dto.StudentDTO;
import com.spring.service.StudentServiceGetStudentsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentControllerGetByStudents {

    // Dependency Injection of Service Layer
    @Autowired
    StudentServiceGetStudentsImpl studentServiceGetStudents;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudents() {
        return studentServiceGetStudents.getStudents();
    }
}
