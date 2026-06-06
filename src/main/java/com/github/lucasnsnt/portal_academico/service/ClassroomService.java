package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.repository.iClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClassroomService {

    private final iClassroomRepository classroomRepository;

}
