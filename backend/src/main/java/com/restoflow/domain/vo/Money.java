package com.restoflow.domain.vo;

import java.math.BigDecimal;

public record Money(BigDecimal amount) {
    public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative or null");
        }
    }
    
    public static Money of(String value) {
        return new Money(new BigDecimal(value));
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount()));
    }
}
