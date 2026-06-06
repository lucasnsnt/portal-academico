package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.repository.iCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final iCourseRepository courseRepository;
}
