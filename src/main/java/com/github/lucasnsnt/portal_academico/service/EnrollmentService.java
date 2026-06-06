package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.repository.iEnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnrollmentService {

    private final iEnrollmentRepository enrollmentRepository;

    public double calculateGradeAverage(double  grade1, double  grade2, double grade3){

        return (grade1 + grade2 + grade3) / 3;

    }

    public boolean isApproved(double gradeAverage){
        return gradeAverage >= 6.0;
    }

}
