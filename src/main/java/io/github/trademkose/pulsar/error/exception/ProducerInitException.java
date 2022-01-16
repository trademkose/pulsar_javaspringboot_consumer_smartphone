package io.github.trademkose.pulsar.error.exception;

public class ProducerInitException extends RuntimeException {
    public ProducerInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProducerInitException(String message) {
        super(message);
    }
}
