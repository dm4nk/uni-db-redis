package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Classroom;

import java.util.Set;

public interface ClassroomRepository {
    Classroom pop();

    void add(Classroom classroom);

    void add(Classroom classroom, String key);

    Set<Classroom> getAll();

    Set<Classroom> intersection(Set<String> keys);

    Set<Classroom> union(Set<String> keys);

    Set<Classroom> difference(Set<String> keys);
}
