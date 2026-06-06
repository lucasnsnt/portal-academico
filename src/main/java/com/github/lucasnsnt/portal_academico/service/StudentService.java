package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.repository.iEnrollmentRepository;
import com.github.lucasnsnt.portal_academico.repository.iStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final iStudentRepository studentRepository;

}
