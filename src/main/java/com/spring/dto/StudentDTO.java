package com.spring.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private long id;
    private String name;
    private int classNumber;
    private Date createdAt;
}
