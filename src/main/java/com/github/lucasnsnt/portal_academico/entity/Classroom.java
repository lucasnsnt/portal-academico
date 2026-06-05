package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    private String code;

    private byte semester;

    private Year year;

    @OneToMany(mappedBy = "classroom")
    private List<Enrollment> enrollments;

    @ManyToOne
    private Course course;

}
