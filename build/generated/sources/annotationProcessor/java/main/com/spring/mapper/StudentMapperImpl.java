package com.spring.mapper;

import com.spring.dto.StudentDTO;
import com.spring.entity.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T20:57:55+0000",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.8 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public List<StudentDTO> convertEntityToDto(List<StudentEntity> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( studentEntity.size() );
        for ( StudentEntity studentEntity1 : studentEntity ) {
            list.add( studentEntityToStudentDTO( studentEntity1 ) );
        }

        return list;
    }

    protected StudentDTO studentEntityToStudentDTO(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( studentEntity.getId() );
        studentDTO.setName( studentEntity.getName() );
        studentDTO.setClassNumber( studentEntity.getClassNumber() );
        studentDTO.setCreatedAt( studentEntity.getCreatedAt() );

        return studentDTO;
    }
}
