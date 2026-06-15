package com.github.lucasnsnt.portal_academico.service;

import com.github.lucasnsnt.portal_academico.entity.Classroom;
import com.github.lucasnsnt.portal_academico.repository.iClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClassroomService {

    private final iClassroomRepository classroomRepository;

    public Optional<Classroom> findClassroomByCode(String code) {
        return classroomRepository.findById(code);
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(String code) {
        classroomRepository.deleteById(code);
    }

    public Classroom getStudentsClassByCode(String code) {
        return null;
    }
}
