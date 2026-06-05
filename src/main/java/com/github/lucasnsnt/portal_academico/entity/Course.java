package com.github.lucasnsnt.portal_academico.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

    private String name;

    @Id
    private String code;

    private String syllabus;
}
