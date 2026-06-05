package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String registrationNumber;

    private String name;

    private String Address;

    private LocalDate enrollmentDate;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}
