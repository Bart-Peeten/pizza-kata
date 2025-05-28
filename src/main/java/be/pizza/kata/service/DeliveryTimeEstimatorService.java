package be.pizza.kata.service;

import java.util.UUID;

/**
 * Interface for estimating the delivery time.
 */
public interface DeliveryTimeEstimatorService {

    /**
     * Estimates the delivery time.
     * @param orderId the id of the customers order
     * @return the estimated delivery time in minutes
     */
    String estimateDeliveryTime(UUID orderId);

}
