package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.entity.Student;
import com.github.lucasnsnt.portal_academico.repository.iStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final iStudentRepository studentRepository;

    public Optional<Student> findStudentByRegistrationNumber(String registrationNumber) {
        return studentRepository.findById(registrationNumber);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentByRegistrationNumber(String registrationNumber) {
        studentRepository.deleteById(registrationNumber);
    }
}
