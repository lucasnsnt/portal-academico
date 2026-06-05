package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Student {

    @Id
    private String registrationNumber;

    private String name;

    private String Address;

    private LocalDate enrollmentDate;

}
