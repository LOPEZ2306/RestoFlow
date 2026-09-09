package com.restoflow.domain.exception;

public class TableAlreadyClaimedException extends RuntimeException {
    public TableAlreadyClaimedException(String message) {
        super(message);
    }
}
