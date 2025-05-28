package be.pizza.kata;

import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import be.pizza.kata.service.impl.DefaultPizzaOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaOrderServiceTest {

    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @InjectMocks
    private DefaultPizzaOrderService pizzaOrderService;

    @Test
    void testCreateOrder() {
        // Arrange
        String pizza = "Margherita";
        String size = "Large";

        PizzaOrder expectedOrder = new PizzaOrder();
        expectedOrder.setId(UUID.randomUUID());
        expectedOrder.setPizza(pizza);
        expectedOrder.setSize(size);

        when(pizzaOrderRepository.save(any(PizzaOrder.class))).thenReturn(expectedOrder);

        // Act
        PizzaOrder actualOrder = pizzaOrderService.createOrder(pizza, size);

        // Assert
        assertEquals(expectedOrder.getId(), actualOrder.getId());
        assertEquals(expectedOrder.getPizza(), actualOrder.getPizza());
        assertEquals(expectedOrder.getSize(), actualOrder.getSize());
    }
}
