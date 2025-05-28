package be.pizza.kata.service.impl;

import be.pizza.kata.enitity.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import be.pizza.kata.service.DeliveryTimeEstimatorService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Default implementation of {@link DeliveryTimeEstimatorService}.
 */
@Service
public class DefaultDeliveryTimeEstimatorService implements DeliveryTimeEstimatorService {

    private final PizzaOrderRepository pizzaOrderRepository;

    /**
     * Ctor to create a new instance of the {@link DefaultDeliveryTimeEstimatorService}
     *
     * @param pizzaOrderRepository {@link PizzaOrderRepository}
     */
    public DefaultDeliveryTimeEstimatorService(final PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    @Override
    public String estimateDeliveryTime(UUID orderId) {
        final Optional<PizzaOrder> order = pizzaOrderRepository.findById(orderId);
        return  order.isPresent() ? order.get().estimateDeliveryTime() : "Unknown";
    }
}
