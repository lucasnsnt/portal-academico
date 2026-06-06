package com.github.lucasnsnt.portal_academico.repository;

import com.github.lucasnsnt.portal_academico.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCourseRepository extends JpaRepository<Course, String> {
}
