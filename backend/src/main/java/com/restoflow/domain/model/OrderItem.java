package com.restoflow.domain.model;

import com.restoflow.domain.vo.Money;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class OrderItem {
    private UUID id;
    private UUID menuItemId;
    private int quantity;
    private Money unitPrice;
    private String notes;

    public Money getTotal() {
        return new Money(unitPrice.amount().multiply(java.math.BigDecimal.valueOf(quantity)));
    }
}
