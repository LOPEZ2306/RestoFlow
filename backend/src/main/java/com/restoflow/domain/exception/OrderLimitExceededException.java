package com.restoflow.domain.exception;

public class OrderLimitExceededException extends RuntimeException {
    public OrderLimitExceededException(String message) {
        super(message);
    }
}
