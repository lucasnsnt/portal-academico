package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.entity.Course;
import com.github.lucasnsnt.portal_academico.repository.iCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final iCourseRepository courseRepository;

    public Optional<Course> getCourseByCode(String code) {
        return courseRepository.findById(code);
    }
}
