package io.github.trademkose.pulsar.error.exception;

import java.io.IOException;

public class ClientInitException extends IOException {
    public ClientInitException(String message) {
        super(message);
    }

    public ClientInitException(String message, Throwable cause) {
        super(message, cause);
    }
}
