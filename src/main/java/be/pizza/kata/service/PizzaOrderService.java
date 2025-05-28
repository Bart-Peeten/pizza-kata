package be.pizza.kata.service;

import be.pizza.kata.domain.PizzaOrder;

import java.util.List;

/**
 * Service interface for creating pizza orders.
 * This interface defines the contract for handling pizza orders,
 * including creating a new order with the specified pizza type and size.
 */
public interface PizzaOrderService {

    /**
     * Creates a new pizza order with the specified type and size.
     *
     * @param pizza the type of pizza to be ordered
     * @param size the size of the pizza to be ordered
     * @return a {@link PizzaOrder} object containing the details of the created order
     */
    PizzaOrder createOrder(String pizza, String size);

    /**
     * Creates a new pizza order with the specified type, size and toppings.
     *
     * @param pizza    the type of pizza to be ordered
     * @param size     the size of the pizza to be ordered
     * @param toppings the toppings on a pizza.
     * @return a {@link PizzaOrder} object containing the details of the created order
     */
    PizzaOrder createOrder(String pizza, String size, List<String> toppings);
}
