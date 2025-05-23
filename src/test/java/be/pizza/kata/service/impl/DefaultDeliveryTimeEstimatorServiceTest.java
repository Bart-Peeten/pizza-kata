package be.pizza.kata.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultDeliveryTimeEstimatorServiceTest {

    private DefaultDeliveryTimeEstimatorService deliveryTimeEstimatorService;

    @BeforeEach
    void setUp() {
        deliveryTimeEstimatorService = new DefaultDeliveryTimeEstimatorService();
    }

    @Test
    void testEstimateDeliveryTime() {
        // Arrange
        String expectedTime = "20 minutes";

        // Act
        String actualTime = deliveryTimeEstimatorService.estimateDeliveryTime();

        // Assert
        assertEquals(expectedTime, actualTime);
    }

}