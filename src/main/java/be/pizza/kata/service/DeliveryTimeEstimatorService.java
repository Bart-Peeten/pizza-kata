package be.pizza.kata.service;

/**
 * Interface for estimating the delivery time.
 */
public interface DeliveryTimeEstimatorService {

    /**
     * Estimates the delivery time.
     * @return the estimated delivery time in minutes
     */
    String estimateDeliveryTime();
}
