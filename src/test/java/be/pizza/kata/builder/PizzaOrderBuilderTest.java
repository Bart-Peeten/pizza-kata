package be.pizza.kata.builder;

import be.pizza.kata.domain.Pizza;
import be.pizza.kata.domain.PizzaOrder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaOrderBuilderTest {

    @Test
    void build_shouldCreateEmptyOrder_whenNoPizzaAdded() {
        PizzaOrderBuilder builder = new PizzaOrderBuilder();
        PizzaOrder order = builder.build();
        assertNotNull(order);
        assertTrue(order.getPizzas().isEmpty(), "Order should be empty when no pizzas added");
    }

    @Test
    void build_shouldContainOnePizza_whenWithPizzaCalledOnce() {
        Pizza pizza = new Pizza("Margherita", "small");
        PizzaOrderBuilder builder = new PizzaOrderBuilder()
                .withPizza(pizza);

        PizzaOrder order = builder.build();

        assertEquals(1, order.getPizzas().size());
        assertTrue(order.getPizzas().contains(pizza));
    }

    @Test
    void build_shouldContainAllPizzas_whenWithPizzasCalled() {
        Pizza pizza1 = new Pizza("Pepperoni", "large");
        Pizza pizza2 = new Pizza("Hawaiian", "medium");
        PizzaOrderBuilder builder = new PizzaOrderBuilder()
                .withPizzas(Arrays.asList(pizza1, pizza2));

        PizzaOrder order = builder.build();

        assertEquals(2, order.getPizzas().size());
        assertTrue(order.getPizzas().containsAll(Arrays.asList(pizza1, pizza2)));
    }

    @Test
    void build_shouldContainAllPizzas_whenWithPizzaAndWithPizzasCalled() {
        Pizza pizza1 = new Pizza("Pepperoni", "large");
        Pizza pizza2 = new Pizza("Hawaiian", "medium");
        Pizza pizza3 = new Pizza("Veggie", "small");

        PizzaOrderBuilder builder = new PizzaOrderBuilder()
                .withPizza(pizza3)
                .withPizzas(Arrays.asList(pizza1, pizza2));

        PizzaOrder order = builder.build();

        assertEquals(3, order.getPizzas().size());
        assertTrue(order.getPizzas().containsAll(Arrays.asList(pizza1, pizza2, pizza3)));
    }

    @Test
    void withPizzas_shouldAddEmptyListWithoutError() {
        PizzaOrderBuilder builder = new PizzaOrderBuilder()
                .withPizzas(Collections.emptyList());

        PizzaOrder order = builder.build();

        assertNotNull(order);
        assertTrue(order.getPizzas().isEmpty());
    }
}
