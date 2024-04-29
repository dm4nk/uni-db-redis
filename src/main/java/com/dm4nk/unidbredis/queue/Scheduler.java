package com.dm4nk.unidbredis.queue;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@AllArgsConstructor
public class Scheduler {
    private final MessagePublisher publisher;

    @Scheduled(fixedRate = 1000L)
    public void createRedisEvent() {
        publisher.publish("Message Received");
    }
}
