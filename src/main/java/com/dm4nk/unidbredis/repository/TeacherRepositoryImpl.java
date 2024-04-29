package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Teacher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    private static final String KEY = "Teacher";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    public TeacherRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Teacher get(String teacherName) {
        return (Teacher) hashOperations.get(KEY, teacherName);
    }

    @Override
    public void put(Teacher teacher) {
        hashOperations.put(KEY, teacher.getName(), teacher);
    }

    @Override
    public void update(String teacherName, Teacher teacher) {
        hashOperations.delete(KEY, teacherName);
        hashOperations.put(KEY, teacher.getName(), teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return hashOperations.values(KEY).stream().map(obj -> (Teacher) obj).collect(Collectors.toList());
    }
}
