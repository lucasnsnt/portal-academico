package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.Year;

@Entity
public class Classroom {

    @Id
    private int code;

    private String semester;

    private Year year;

}
