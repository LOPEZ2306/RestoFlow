package com.restoflow.domain.vo;

public record ValidationCode(String code) {
    public ValidationCode {
        if (code == null || !code.matches("\\d{6}")) {
            throw new IllegalArgumentException("Validation code must be exactly 6 digits");
        }
    }
}
