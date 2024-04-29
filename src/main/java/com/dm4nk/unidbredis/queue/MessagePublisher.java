package com.dm4nk.unidbredis.queue;

public interface MessagePublisher {
    void publish(String message);
}
