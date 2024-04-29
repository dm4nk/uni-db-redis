package com.dm4nk.unidbredis.controller;

import com.dm4nk.unidbredis.model.Student;
import com.dm4nk.unidbredis.model.UpdateStudentRequest;
import com.dm4nk.unidbredis.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping
    public void push(@RequestBody Student student) {
        studentRepository.push(student);
    }

    @GetMapping
    public Student pop() {
        return studentRepository.pop();
    }

    @PatchMapping
    public void update(@RequestBody UpdateStudentRequest updateStudentRequest) {
        studentRepository.update(updateStudentRequest.getOldStudent(), updateStudentRequest.getNewStudent());
    }

    @DeleteMapping
    public void delete(@RequestBody Student student) {
        studentRepository.delete(student);
    }
}
