package com.spring.service;

import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import com.spring.mapper.StudentMapper;
import com.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceGetStudentsImpl implements StudentServiceGetStudents {

    // Dependency Injection of Repository Bean
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudents() {
        List<StudentEntity> studentEntities =  studentRepository.findAll();
        return studentMapper.convertEntityToDto(studentEntities);
    }
}
