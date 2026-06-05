package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Classroom classroom;

    private double firtGrade;

    private double secondGrade;

    private double thirdGrade;
}
