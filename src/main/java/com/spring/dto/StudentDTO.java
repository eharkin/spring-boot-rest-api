package com.spring.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentDTO implements Comparable<StudentDTO> {
    private long id;
    private String name;
    private int classNumber;
    private LocalDate createdAt;


    @Override
    public int compareTo(StudentDTO o) {
        return (int) (this.getId() - o.getId());
    }
}
