package be.pizza.kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaOrderService {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    public PizzaOrder createOrder(String pizza, String size) {
        // TODO: Implement this method
        return null;
    }

    public String estimateDeliveryTime() {
        // TODO: Implement this method
        return null;
    }
}
