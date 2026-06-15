package com.github.lucasnsnt.portal_academico.controller;


import com.github.lucasnsnt.portal_academico.entity.Classroom;
import com.github.lucasnsnt.portal_academico.entity.Student;
import com.github.lucasnsnt.portal_academico.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping("/{code}")
    public ResponseEntity<Classroom> getClassroomByCode(@PathVariable String code) {
        return classroomService.findClassroomByCode(code).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Classroom save = classroomService.createClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);

    }

    @PutMapping("/{code}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable String code ,@RequestBody Classroom classroom) {
        Classroom save = classroomService.updateClassroom(classroom);
        return ResponseEntity.ok(save);

    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Classroom> deleteClassroom(@PathVariable String code) {
        if (!classroomService.findClassroomByCode(code).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        classroomService.deleteClassroom(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{code}/students")
    public ResponseEntity<List<Student>> getClassroomStudentsByCode(@PathVariable String code) {
        return null;
    }

}
