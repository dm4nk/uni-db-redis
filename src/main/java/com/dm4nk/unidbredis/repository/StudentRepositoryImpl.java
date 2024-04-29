package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final String KEY = "Students";
    private final RedisTemplate<String, Object> redisTemplate;
    private ListOperations<String, Object> listOperations;

    @Autowired
    public StudentRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        listOperations = redisTemplate.opsForList();
    }

    @Override
    public void push(Student student) {
        listOperations.rightPush(KEY, student);
    }

    @Override
    public Student pop() {
        return (Student) listOperations.leftPop(KEY);
    }

    @Override
    public void update(Student oldStudent, Student newStudent) {
        Long index = listOperations.indexOf(KEY, oldStudent);
        if (index != null) {
            listOperations.set(KEY, index, newStudent);
        }
    }

    @Override
    public void delete(Student student) {
        listOperations.remove(KEY, 1, student);
    }
}
