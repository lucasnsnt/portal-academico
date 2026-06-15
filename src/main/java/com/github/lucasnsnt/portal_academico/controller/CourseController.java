package com.github.lucasnsnt.portal_academico.controller;


import com.github.lucasnsnt.portal_academico.entity.Course;
import com.github.lucasnsnt.portal_academico.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{code}")
    public ResponseEntity<Course> getCourseByCode(@PathVariable String code) {
        return courseService.getCourseByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course save = courseService.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Course> uptadeCourse(@PathVariable String code, @RequestBody Course course) {
        Course save = courseService.updateCourse(course);
        return ResponseEntity.ok(save);

    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Course> deleteCourse(@PathVariable String code) {
        if (!courseService.getCourseByCode(code).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseService.deleteCourse(code);
        return ResponseEntity.noContent().build();
    }

}
