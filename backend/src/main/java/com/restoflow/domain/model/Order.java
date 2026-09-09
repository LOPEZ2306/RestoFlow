package com.restoflow.domain.model;

import com.restoflow.domain.exception.InvalidOrderTransitionException;
import com.restoflow.domain.vo.Money;
import com.restoflow.domain.vo.OrderStatus;
import com.restoflow.domain.vo.ValidationCode;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Order {
    private UUID id;
    private UUID sessionId;
    private UUID tableId;
    private OrderStatus status;
    private ValidationCode validationCode;
    private UUID validatedBy;
    private LocalDateTime validatedAt;
    private String cancelReasonCode;
    private String cancelReasonText;
    private Money totalAmount;
    private LocalDateTime createdAt;
    
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    public void sendForValidation() {
        if (this.status != OrderStatus.CREATED) {
            throw new InvalidOrderTransitionException("Order must be in CREATED state to send for validation.");
        }
        this.status = OrderStatus.PENDING_VALIDATION;
    }

    public void validate(UUID staffId) {
        if (this.status != OrderStatus.PENDING_VALIDATION) {
            throw new InvalidOrderTransitionException("Order must be PENDING_VALIDATION to be validated.");
        }
        this.status = OrderStatus.COOKING;
        this.validatedBy = staffId;
        this.validatedAt = LocalDateTime.now();
    }

    public void reject(String reasonCode, String reasonText) {
        if (this.status != OrderStatus.PENDING_VALIDATION) {
            throw new InvalidOrderTransitionException("Order must be PENDING_VALIDATION to be rejected.");
        }
        this.status = OrderStatus.CANCELLED;
        this.cancelReasonCode = reasonCode;
        this.cancelReasonText = reasonText;
    }

    public void markReady() {
        if (this.status != OrderStatus.COOKING) {
            throw new InvalidOrderTransitionException("Order must be COOKING to be marked as READY.");
        }
        this.status = OrderStatus.READY;
    }

    public void markServed() {
        if (this.status != OrderStatus.READY) {
            throw new InvalidOrderTransitionException("Order must be READY to be marked as SERVED.");
        }
        this.status = OrderStatus.SERVED;
    }

    public void calculateTotal() {
        this.totalAmount = items.stream()
                .map(OrderItem::getTotal)
                .reduce(Money.zero(), Money::add);
    }
}
