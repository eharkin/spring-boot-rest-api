package com.spring.service;

import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import com.spring.mapper.StudentMapper;
import com.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceGetStudentsImpl implements StudentServiceGetStudents {

    // Dependency Injection of Repository Bean
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Dependency Injection of Repository Bean at constructor injection
    @Autowired
    public StudentServiceGetStudentsImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> getStudents() {
        List<StudentEntity> studentEntities =  studentRepository.findAll();
        return studentMapper.convertEntityToDto(studentEntities);
    }
}
