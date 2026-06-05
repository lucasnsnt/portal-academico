package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Enrollment {

    private Student student;

    private Classroom classroom;

    private int firtGrade;

    private int secondGrade;

    private int thirdGrade;
}
