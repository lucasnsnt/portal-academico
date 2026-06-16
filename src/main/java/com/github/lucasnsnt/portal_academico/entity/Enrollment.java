package com.github.lucasnsnt.portal_academico.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
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
    @DecimalMin(value = "0.0", inclusive = true, message = "Nota deve ser maior ou igual a 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Nota deve ser menor ou igual a 10.0")
    private double firstGrade;

    @Column(name = "second_grade")
    @DecimalMin(value = "0.0", inclusive = true, message = "Nota deve ser maior ou igual a 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Nota deve ser menor ou igual a 10.0")
    private double secondGrade;

    @Column(name = "third_grade")
    @DecimalMin(value = "0.0", inclusive = true, message = "Nota deve ser maior ou igual a 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Nota deve ser menor ou igual a 10.0")
    private double thirdGrade;

}
