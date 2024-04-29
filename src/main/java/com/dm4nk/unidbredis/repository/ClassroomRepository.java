package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Classroom;

import java.util.Set;

public interface ClassroomRepository {
    Classroom pop();

    void add(Classroom classroom);

    Set<Classroom> getAll();
}
