package com.spring.mapper;

import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<StudentDTO> convertEntityToDto(List<StudentEntity> studentEntity);
}
