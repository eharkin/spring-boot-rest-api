package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@Entity(name = "student")
@Table(name = "student")
public class StudentEntity {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private int classNumber;
    @CreatedDate
    private Date createdAt;
}
