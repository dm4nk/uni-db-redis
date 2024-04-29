package com.dm4nk.unidbredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Classroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom implements Serializable {
    private Integer number;
    private String locationName;
}
