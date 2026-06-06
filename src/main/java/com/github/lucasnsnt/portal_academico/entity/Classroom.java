package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    private String code;

    @Column(name = "semester")
    private byte semester;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "classroom")
    private List<Enrollment> enrollments;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
