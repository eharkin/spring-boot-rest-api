package com.spring.controller;

import com.spring.dto.StudentDTO;
import com.spring.service.StudentServiceGetStudents;
import com.spring.service.StudentServiceGetStudentsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentControllerGetByStudents {

    // Dependency Injection of Service Layer
    @Autowired
    StudentServiceGetStudents studentServiceGetStudents;

    @GetMapping(value = "getAllStudents", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getStudents() {
        return studentServiceGetStudents.getStudents();
    }
}
