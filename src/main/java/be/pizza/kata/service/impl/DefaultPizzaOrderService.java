package be.pizza.kata.service.impl;

import be.pizza.kata.PizzaOrder;
import be.pizza.kata.PizzaOrderRepository;
import be.pizza.kata.service.PizzaOrderService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPizzaOrderService implements PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;

    /**
     * Ctor to create a new instance of {@link DefaultPizzaOrderService}.
     * @param pizzaOrderRepository The repository to use for persistence.
     */
    public DefaultPizzaOrderService(final PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public PizzaOrder createOrder(String pizza, String size) {
        PizzaOrder order = new PizzaOrder();
        order.setPizza(pizza);
        order.setSize(size);
        return pizzaOrderRepository.save(order);
    }
}
