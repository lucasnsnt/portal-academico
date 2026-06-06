package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;


    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}
