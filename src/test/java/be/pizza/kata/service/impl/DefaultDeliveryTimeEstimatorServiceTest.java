package be.pizza.kata.service.impl;

import be.pizza.kata.enitity.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultDeliveryTimeEstimatorServiceTest {

    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @InjectMocks
    private DefaultDeliveryTimeEstimatorService deliveryTimeEstimatorService;

    @Test
    void testEstimateDeliveryTime() {
        // Arrange
        PizzaOrder pizzaOrder = mock(PizzaOrder.class);
        String expectedTime = "20 minutes";
        UUID uuid = UUID.randomUUID();
        when(pizzaOrderRepository.findById(uuid)).thenReturn(Optional.of(pizzaOrder));
        when(pizzaOrder.estimateDeliveryTime()).thenReturn(expectedTime);

        // Act
        String actualTime = deliveryTimeEstimatorService.estimateDeliveryTime(uuid);

        // Assert
        assertEquals(expectedTime, actualTime);
    }
}