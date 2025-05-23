package be.pizza.kata.builder;

import be.pizza.kata.enitity.PizzaOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class PizzaOrderBuilderTest {

    @Test
    void testSetPizza() {
        // Arrange
        String pizza = "Margherita";
        PizzaOrderBuilder builder = new PizzaOrderBuilder();

        // Act
        PizzaOrderBuilder resultBuilder = builder.withPizza(pizza);

        // Assert
        assertSame(builder, resultBuilder, "setPizza should return the builder instance");
    }

    @Test
     void testSetSize() {
        // Arrange
        String size = "Large";
        PizzaOrderBuilder builder = new PizzaOrderBuilder();

        // Act
        PizzaOrderBuilder resultBuilder = builder.withSize(size);

        // Assert
        assertSame(builder, resultBuilder, "setSize should return the builder instance");
    }

    @Test
     void testBuild() {
        // Arrange
        String pizza = "Margherita";
        String size = "Large";
        PizzaOrderBuilder builder = new PizzaOrderBuilder();

        // Act
        PizzaOrder order = builder.withPizza(pizza)
                .withSize(size)
               .build();

        // Assert
        assertNotNull(order.getId(), "Order ID should not be null");
        assertEquals(pizza, order.getPizza(), "Pizza should be set correctly");
        assertEquals(size, order.getSize(), "Size should be set correctly");
    }

    @Test
     void testBuildWithNullToppings() {
        // Arrange
        String pizza = "Margherita";
        String size = "Large";
        PizzaOrderBuilder builder = new PizzaOrderBuilder();

        // Act
        PizzaOrder order = builder.withPizza(pizza)
                .withSize(size)
                .build();

        // Assert
        assertNotNull(order.getId(), "Order ID should not be null");
        assertEquals(pizza, order.getPizza(), "Pizza should be set correctly");
        assertEquals(size, order.getSize(), "Size should be set correctly");
    }
}
