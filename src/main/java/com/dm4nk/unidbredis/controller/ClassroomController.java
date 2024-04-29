package com.dm4nk.unidbredis.controller;

import com.dm4nk.unidbredis.model.Classroom;
import com.dm4nk.unidbredis.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/classrooms")
public class ClassroomController {
    private ClassroomRepository classroomRepository;

    @GetMapping("/all")
    public Set<Classroom> getAll() {
        return classroomRepository.getAll();
    }

    @DeleteMapping
    public Classroom pop() {
        return classroomRepository.pop();
    }

    @PostMapping
    public void add(@RequestBody Classroom classroom) {
        classroomRepository.add(classroom);
    }
}
