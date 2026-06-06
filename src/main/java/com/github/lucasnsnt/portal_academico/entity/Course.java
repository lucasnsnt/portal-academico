package com.github.lucasnsnt.portal_academico.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @NotBlank
    @Id
    private String code;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "syllabus")
    private String syllabus;

    @OneToMany(mappedBy = "course")
    private List<Classroom> classrooms;

}
