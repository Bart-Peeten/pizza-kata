package be.pizza.kata.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderResponseTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String orderId = "123e4567-e89b-12d3-a456-426614174000";
        String estimatedTime = "20 minutes";

        // Act
        OrderResponse response = new OrderResponse(orderId, estimatedTime);

        // Assert
        assertEquals(orderId, response.getOrderId(), "Order ID should be set correctly");
        assertEquals(estimatedTime, response.getEstimatedTime(), "Estimated time should be set correctly");
    }

    @Test
    void testSetters() {
        // Arrange
        OrderResponse response = new OrderResponse("", "");
        String orderId = "123e4567-e89b-12d3-a456-426614174000";
        String estimatedTime = "20 minutes";

        // Act
        response.setOrderId(orderId);
        response.setEstimatedTime(estimatedTime);

        // Assert
        assertEquals(orderId, response.getOrderId(), "Order ID should be set correctly");
        assertEquals(estimatedTime, response.getEstimatedTime(), "Estimated time should be set correctly");
    }

}