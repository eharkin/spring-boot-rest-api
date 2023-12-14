package com.spring.service;

import com.spring.dto.StudentDTO;

import java.util.List;

// to follow SOLID Design Principles

/* SINGLE RESPONSIBILITY
   Open Closed Design
   Liskov Subs
   Interface Segeration
   Dependency Inversion
 */
public interface StudentServiceGetStudents {

    // default its regarding abstract and public
    List<StudentDTO> getStudents();
}
