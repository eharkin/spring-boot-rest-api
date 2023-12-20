package com.spring.service;

import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import com.spring.mapper.StudentMapper;
import com.spring.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepositoryMock;

    @Mock
    StudentMapper studentMapperMock;

    @InjectMocks StudentServiceGetStudentsImpl studentServiceGetStudents;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        studentServiceGetStudents =
                new StudentServiceGetStudentsImpl(studentRepositoryMock, studentMapperMock);
    }

    @Test
    void fetchStudentsInformation() {
        // given
        // builder pattern using lombok
        StudentEntity studentEntity = StudentEntity.builder()
                .id(100)
                .classNumber(55)
                .createdAt(LocalDate.now())
                .build();

        StudentDTO studentDTO = StudentDTO.builder()
                .id(103)
                .classNumber(55)
                .createdAt(LocalDate.now())
                .build();

        StudentDTO studentDTO2 = StudentDTO.builder()
                .id(100)
                .classNumber(55)
                .createdAt(LocalDate.now())
                .build();


        List<StudentDTO> expected = List.of(studentDTO, studentDTO2);

        when(studentRepositoryMock.findAll()).thenReturn(List.of(studentEntity, studentEntity, studentEntity));
        when(studentMapperMock.convertEntityToDto(any())).thenReturn(expected);

        //when
        List<StudentDTO> studentsActual = studentServiceGetStudents.getStudents();
        Arrays.sort(studentsActual.toArray());
        //then
        verify(studentRepositoryMock).findAll();
        verify(studentMapperMock).convertEntityToDto(any());

        assertThat(studentsActual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void fetchStudentsInformationThrowsException() {
        //  given
        //  builder pattern using lombok
        StudentDTO studentDTO = StudentDTO.builder()
                .id(100)
                .classNumber(55)
                .createdAt(LocalDate.now())
                .build();

        List<StudentDTO> expected = List.of(studentDTO, studentDTO);

        when(studentRepositoryMock.findAll()).thenThrow(new NullPointerException("exception occurred"));
        when(studentMapperMock.convertEntityToDto(any())).thenReturn(expected);

        //when //then
        assertThrows(NullPointerException.class, () ->  studentServiceGetStudents.getStudents());
    }

}
