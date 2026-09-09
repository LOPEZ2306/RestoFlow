package com.restoflow.domain.model;

import com.restoflow.domain.vo.Money;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Payment {
    private UUID id;
    private UUID sessionId;
    private UUID registeredBy;
    private Money totalAmount;
    private String paymentMethod; // EFECTIVO, TARJETA, TRANSFERENCIA
    private LocalDateTime paidAt;
}
