package com.github.lucasnsnt.portal_academico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "registration_number")
    private String registrationNumber;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "address")
    private String address;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;


    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}
