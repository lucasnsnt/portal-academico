package com.github.lucasnsnt.portal_academico.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "syllabus")
    private String syllabus;

    @OneToMany(mappedBy = "course")
    private List<Classroom> classrooms;

}
