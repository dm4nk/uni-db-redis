package com.dm4nk.unidbredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UniDbRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniDbRedisApplication.class, args);
    }

}
