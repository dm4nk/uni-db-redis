package com.dm4nk.unidbredis.controller;

import com.dm4nk.unidbredis.model.Teacher;
import com.dm4nk.unidbredis.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/teachers")
public class TeacherController {
    private TeacherRepository teacherRepository;

    @PostMapping
    public void put(@RequestBody Teacher student) {
        teacherRepository.put(student);
    }

    @GetMapping
    public Teacher get(@RequestParam String teacherName) {
        return teacherRepository.get(teacherName);
    }

    @PatchMapping
    public void update(@RequestParam String teacherName, @RequestBody Teacher teacher) {
        teacherRepository.update(teacherName, teacher);
    }

    @GetMapping("/all")
    public List<Teacher> getAll() {
        return teacherRepository.getAll();
    }
}
