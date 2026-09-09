package com.restoflow.domain.model;

import com.restoflow.domain.exception.InvalidOrderTransitionException;
import com.restoflow.domain.vo.OrderStatus;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testValidTransitions() {
        Order order = Order.builder()
                .status(OrderStatus.CREATED)
                .build();

        order.sendForValidation();
        assertEquals(OrderStatus.PENDING_VALIDATION, order.getStatus());

        order.validate(UUID.randomUUID());
        assertEquals(OrderStatus.COOKING, order.getStatus());
        assertNotNull(order.getValidatedBy());
        assertNotNull(order.getValidatedAt());

        order.markReady();
        assertEquals(OrderStatus.READY, order.getStatus());

        order.markServed();
        assertEquals(OrderStatus.SERVED, order.getStatus());
    }

    @Test
    void testInvalidValidateTransition() {
        Order order = Order.builder()
                .status(OrderStatus.CREATED)
                .build();

        assertThrows(InvalidOrderTransitionException.class, () -> order.validate(UUID.randomUUID()));
    }

    @Test
    void testRejectOrder() {
        Order order = Order.builder()
                .status(OrderStatus.PENDING_VALIDATION)
                .build();

        order.reject("FRAUD", "Not at table");
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
        assertEquals("FRAUD", order.getCancelReasonCode());
    }
}
