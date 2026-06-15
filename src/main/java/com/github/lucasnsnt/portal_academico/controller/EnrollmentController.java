package com.github.lucasnsnt.portal_academico.controller;


import com.github.lucasnsnt.portal_academico.entity.Enrollment;
import com.github.lucasnsnt.portal_academico.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id){
        return enrollmentService.getEnrollmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment save = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id , @RequestBody Enrollment enrollment) {
        Enrollment save = enrollmentService.updateEnrollment(enrollment);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Enrollment> deleteEnrollment(@PathVariable Long id) {
        if (!enrollmentService.getEnrollmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        enrollmentService.deleteEnrollmentById(id);
        return ResponseEntity.noContent().build();
    }

}
