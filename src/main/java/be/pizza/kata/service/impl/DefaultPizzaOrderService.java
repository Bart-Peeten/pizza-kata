package be.pizza.kata.service.impl;

import be.pizza.kata.builder.PizzaBuilder;
import be.pizza.kata.builder.PizzaOrderBuilder;
import be.pizza.kata.domain.Pizza;
import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.domain.Topping;
import be.pizza.kata.repository.PizzaOrderRepository;
import be.pizza.kata.repository.PizzaRepository;
import be.pizza.kata.service.PizzaOrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DefaultPizzaOrderService implements PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaRepository pizzaRepository;

    /**
     * Ctor to create a new instance of {@link DefaultPizzaOrderService}.
     * @param pizzaOrderRepository The repository to use for {@link PizzaOrder} persistence.
     * @param pizzaRepository      The repository to use for {@link Pizza} persistence.
     */
    public DefaultPizzaOrderService(final PizzaOrderRepository pizzaOrderRepository, final PizzaRepository pizzaRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public PizzaOrder createOrder(String pizza, String size) {
        Pizza pizzaToOrder = new PizzaBuilder()
                .withSize(size)
                .withType(pizza)
                .build();
        pizzaRepository.save(pizzaToOrder);

        PizzaOrder pizzaOrder = new PizzaOrderBuilder()
                .withPizza(pizzaToOrder)
                .build();
        return pizzaOrderRepository.save(pizzaOrder);
    }

    @Override
    public PizzaOrder createOrder(final String pizza, final String size, final List<String> toppings) {
        if(CollectionUtils.isEmpty(toppings)) {
            return createOrder(pizza, size);
        }
        Pizza pizzaToOrder = new PizzaBuilder()
                .withSize(size)
                .withType(pizza)
                .withToppings(toToppings(toppings))
                .build();
        pizzaRepository.save(pizzaToOrder);

        PizzaOrder pizzaOrder = new PizzaOrderBuilder()
                .withPizza(pizzaToOrder)
                .build();
        return pizzaOrderRepository.save(pizzaOrder);
    }

    private List<Topping> toToppings(List<String> toppings) {
        return toppings.stream()
                .map(Topping::new)
                .toList();
    }
}
