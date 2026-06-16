package com.github.lucasnsnt.portal_academico.repository;

import com.github.lucasnsnt.portal_academico.entity.Enrollment;
import com.github.lucasnsnt.portal_academico.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iEnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByClassroom_code(String code);

    List<Enrollment> findByStudent_registrationNumber(String registrationNumber);
}
