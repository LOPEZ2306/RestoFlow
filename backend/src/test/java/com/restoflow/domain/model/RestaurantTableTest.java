package com.restoflow.domain.model;

import com.restoflow.domain.exception.TableAlreadyClaimedException;
import com.restoflow.domain.vo.TableStatus;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTableTest {

    @Test
    void testClaimFreeTable() {
        RestaurantTable table = RestaurantTable.builder()
                .number(1)
                .status(TableStatus.FREE)
                .build();

        UUID sessionId = UUID.randomUUID();
        table.claimBy(sessionId);

        assertEquals(TableStatus.OCCUPIED, table.getStatus());
        assertEquals(sessionId, table.getCurrentSessionId());
    }

    @Test
    void testClaimOccupiedTable() {
        RestaurantTable table = RestaurantTable.builder()
                .number(1)
                .status(TableStatus.OCCUPIED)
                .currentSessionId(UUID.randomUUID())
                .build();

        assertThrows(TableAlreadyClaimedException.class, () -> table.claimBy(UUID.randomUUID()));
    }

    @Test
    void testFreeTable() {
        RestaurantTable table = RestaurantTable.builder()
                .number(1)
                .status(TableStatus.OCCUPIED)
                .currentSessionId(UUID.randomUUID())
                .build();

        table.free();

        assertEquals(TableStatus.FREE, table.getStatus());
        assertNull(table.getCurrentSessionId());
    }
}
