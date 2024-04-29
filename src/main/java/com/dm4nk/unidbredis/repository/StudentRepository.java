package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Student;

public interface StudentRepository {
    void push(Student student);
    Student pop();
    void update(Student oldStudent, Student newStudent);
    void delete(Student student);
}
