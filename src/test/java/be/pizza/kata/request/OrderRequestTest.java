package be.pizza.kata.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderRequestTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        OrderRequest request = new OrderRequest();
        String pizza = "MARGHERITA";
        String size = "MEDIUM";

        // Act
        request.setPizza(pizza);
        request.setSize(size);

        // Assert
        assertEquals(pizza, request.getPizza(), "Pizza should be set correctly");
        assertEquals(size, request.getSize(), "Size should be set correctly");
    }
}