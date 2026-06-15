package com.github.lucasnsnt.portal_academico.controller;

import com.github.lucasnsnt.portal_academico.entity.Student;
import com.github.lucasnsnt.portal_academico.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{registrationNumber}")
    public ResponseEntity<Student> getStudentByRegistrationNumber(@PathVariable String registrationNumber) {
        return studentService.findStudentByRegistrationNumber(registrationNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student save = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{registrationNumber}")
    public ResponseEntity<Student>  updateStudent(@PathVariable String registrationNumber
            ,@RequestBody Student student) {
        Student save = studentService.updateStudent(student);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{registrationNumber}")
    public ResponseEntity<Student> deleteStudentByRegistrationNumber(@PathVariable String registrationNumber) {
        if (!studentService.findStudentByRegistrationNumber(registrationNumber).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudentByRegistrationNumber(registrationNumber);
        return ResponseEntity.noContent().build();

    }

}
