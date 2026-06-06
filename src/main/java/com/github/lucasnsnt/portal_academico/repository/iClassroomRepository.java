package com.github.lucasnsnt.portal_academico.repository;

import com.github.lucasnsnt.portal_academico.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iClassroomRepository extends JpaRepository<Classroom, String> {
}
