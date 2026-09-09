package com.restoflow.domain.model;

import com.restoflow.domain.exception.TableAlreadyClaimedException;
import com.restoflow.domain.vo.TableStatus;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class RestaurantTable {
    private UUID id;
    private int number;
    private int capacity;
    private TableStatus status;
    private UUID currentSessionId;

    public void claimBy(UUID sessionId) {
        if (this.status != TableStatus.FREE || this.currentSessionId != null) {
            throw new TableAlreadyClaimedException("Table " + number + " is already occupied.");
        }
        this.status = TableStatus.OCCUPIED;
        this.currentSessionId = sessionId;
    }

    public void free() {
        this.status = TableStatus.FREE;
        this.currentSessionId = null;
    }
}
