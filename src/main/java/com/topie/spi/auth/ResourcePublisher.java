package com.topie.spi.auth;

public interface ResourcePublisher {
    void publish();

    void publish(String message);
}
