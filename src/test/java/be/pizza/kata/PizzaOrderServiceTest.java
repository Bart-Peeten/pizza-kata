package be.pizza.kata;

import be.pizza.kata.domain.Pizza;
import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import be.pizza.kata.repository.PizzaRepository;
import be.pizza.kata.service.impl.DefaultPizzaOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaOrderServiceTest {

    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private DefaultPizzaOrderService pizzaOrderService;

    @Test
    void testCreateOrder() {
        String pizzaType = "Margherita";
        String size = "Large";


        Pizza pizzaToOrder = new Pizza();
        pizzaToOrder.setType(pizzaType);
        pizzaToOrder.setSize(size);

        PizzaOrder expectedOrder = new PizzaOrder();
        expectedOrder.setId(UUID.randomUUID());
        expectedOrder.addPizza(pizzaToOrder);

        when(pizzaRepository.save(any(Pizza.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(pizzaOrderRepository.save(any(PizzaOrder.class))).thenReturn(expectedOrder);

        PizzaOrder actualOrder = pizzaOrderService.createOrder(pizzaType, size);

        assertNotNull(actualOrder);
        assertEquals(expectedOrder.getId(), actualOrder.getId());
        assertFalse(actualOrder.getPizzas().isEmpty());
        Pizza orderedPizza = actualOrder.getPizzas().get(0);
        assertEquals(pizzaType, orderedPizza.getType());
        assertEquals(size, orderedPizza.getSize());
    }
}
