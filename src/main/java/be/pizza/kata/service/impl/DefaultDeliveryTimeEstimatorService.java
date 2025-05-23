package be.pizza.kata.service.impl;

import be.pizza.kata.service.DeliveryTimeEstimatorService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Default implementation of {@link DeliveryTimeEstimatorService}.
 */
@Service
public class DefaultDeliveryTimeEstimatorService implements DeliveryTimeEstimatorService {

    private static final int BASE_TIME = 20;
    private static final int TIME_PER_TOPPING = 2;

    @Override
    public String estimateDeliveryTime() {
        return  BASE_TIME + " minutes";
    }

    @Override
    public String estimateDeliveryTime(final List<String> toppings) {
        int additionalTime = !CollectionUtils.isEmpty(toppings) ? toppings.size() * TIME_PER_TOPPING : 0;
        return (BASE_TIME + additionalTime) + " minutes";
    }
}
