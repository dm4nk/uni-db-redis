package com.dm4nk.unidbredis.repository;

import com.dm4nk.unidbredis.model.Classroom;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ClassroomRepositoryImpl implements ClassroomRepository {
    private static final String KEY = "Classroom";
    private final RedisTemplate<String, Object> redisTemplate;
    private SetOperations<String, Object> setOperations;

    @Autowired
    public ClassroomRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        setOperations = redisTemplate.opsForSet();
    }

    @Override
    public Classroom pop() {
        return (Classroom) setOperations.pop(KEY);
    }

    @Override
    public void add(Classroom classroom) {
        setOperations.add(KEY, classroom);
    }

    @Override
    public Set<Classroom> getAll() {
        return setOperations.members(KEY).stream().map(obj -> (Classroom) obj).collect(Collectors.toSet());
    }
}
