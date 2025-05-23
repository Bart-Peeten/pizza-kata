package be.pizza.kata.service;

import java.util.List;

/**
 * Interface for estimating the delivery time.
 */
public interface DeliveryTimeEstimatorService {

    /**
     * Estimates the delivery time.
     * @return the estimated delivery time in minutes
     */
    String estimateDeliveryTime();

    /**
     * Estimates the delivery time based on toppings.
     * @param toppings the list of toppings
     * @return the estimated delivery time in minutes
     */
    String estimateDeliveryTime(List<String> toppings);
}
