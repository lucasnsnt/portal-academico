package com.github.lucasnsnt.portal_academico.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "classroom")
public class Classroom {

    @NotBlank
    @Id
    private String code;

    @Min(value = 1, message = "Selecione um semestre válido")
    @Max(value = 2, message = "Selecione um semestre válido")
    @Column(name = "semester")
    private byte semester;

    @Column(name = "year")
    private int year;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Enrollment> enrollments;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
