package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @Column(name = "first_grade")
    private double firstGrade;

    @Column(name = "second_grade")
    private double secondGrade;

    @Column(name = "third_grade")
    private double thirdGrade;
}
