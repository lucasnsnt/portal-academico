package com.github.lucasnsnt.portal_academico.repository;

import com.github.lucasnsnt.portal_academico.entity.Enrollment;
import com.github.lucasnsnt.portal_academico.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iStudentRepository extends JpaRepository<Student, String> {
}
