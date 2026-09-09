package com.restoflow.domain.model;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ClientSession {
    private UUID id;
    private UUID tableId;
    private String status; // ACTIVE, EXPIRED, CLOSED
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    
    public void assignTable(UUID newTableId) {
        this.tableId = newTableId;
    }
    
    public void close() {
        this.status = "CLOSED";
    }
}
