package com.github.lucasnsnt.portal_academico.repository;

import com.github.lucasnsnt.portal_academico.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iEnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
