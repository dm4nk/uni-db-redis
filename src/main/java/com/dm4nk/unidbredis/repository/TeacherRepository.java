package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    Teacher get(String teacherName);

    void put(Teacher teacher);

    void update(String teacherName, Teacher teacher);

    List<Teacher> getAll();
}
