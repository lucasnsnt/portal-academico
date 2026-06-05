package com.github.lucasnsnt.portal_academico.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    private String code;

    private String name;

    private String syllabus;

    @OneToMany(mappedBy = "course")
    private List<Classroom> classrooms;

}
