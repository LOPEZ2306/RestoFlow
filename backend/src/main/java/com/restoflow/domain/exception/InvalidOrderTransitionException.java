package com.restoflow.domain.exception;

public class InvalidOrderTransitionException extends RuntimeException {
    public InvalidOrderTransitionException(String message) {
        super(message);
    }
}
