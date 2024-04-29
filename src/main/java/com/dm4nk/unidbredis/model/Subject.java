package com.dm4nk.unidbredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    private String id;
    private String title;
}
