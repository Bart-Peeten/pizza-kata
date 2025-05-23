package be.pizza.kata.service.impl;

import be.pizza.kata.service.DeliveryTimeEstimatorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default implementation of {@link DeliveryTimeEstimatorService}.
 */
@Service
public class DefaultDeliveryTimeEstimatorService implements DeliveryTimeEstimatorService {

    private static final int BASE_TIME = 20;

    @Override
    public String estimateDeliveryTime() {
        return  BASE_TIME + " minutes";
    }

    @Override
    public String estimateDeliveryTime(final List<String> toppings) {
        return "";
    }
}
