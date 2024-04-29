package com.dm4nk.unidbredis.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.nio.charset.StandardCharsets;

@Slf4j
public class MessageSubscriber implements MessageListener {

    public void onMessage(final Message message, final byte[] pattern) {
        log.debug("Message received: {}", new String(message.getBody(), StandardCharsets.UTF_8).substring(7));
    }
}
