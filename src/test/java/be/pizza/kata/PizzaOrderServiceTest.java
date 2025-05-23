package be.pizza.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaOrderServiceTest {

    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @InjectMocks
    private PizzaOrderService pizzaOrderService;

    @Test
    void testCreateOrder() {
        // Arrange
        String pizza = "Margherita";
        String size = "Large";

        PizzaOrder expectedOrder = new PizzaOrder();
        expectedOrder.setId(UUID.randomUUID());
        expectedOrder.setPizza(pizza);
        expectedOrder.setSize(size);

        when(pizzaOrderRepository.save(expectedOrder)).thenReturn(expectedOrder);

        // Act
        PizzaOrder actualOrder = pizzaOrderService.createOrder(pizza, size);

        // Assert
        assertEquals(expectedOrder.getId(), actualOrder.getId());
        assertEquals(expectedOrder.getPizza(), actualOrder.getPizza());
        assertEquals(expectedOrder.getSize(), actualOrder.getSize());
    }

    @Test
    void testEstimateDeliveryTime() {
        // Arrange
        String expectedTime = "20 minutes";

        // Act
        String actualTime = pizzaOrderService.estimateDeliveryTime();

        // Assert
        assertEquals(expectedTime, actualTime);
    }
}
