package be.pizza.kata.builder;

import be.pizza.kata.domain.Pizza;
import be.pizza.kata.domain.PizzaOrder;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderBuilder {

    private final List<Pizza> pizzas = new ArrayList<>();

    public PizzaOrderBuilder withPizza(Pizza pizza) {
        this.pizzas.add(pizza);
        return this;
    }

    public PizzaOrderBuilder withPizzas(List<Pizza> pizzas) {
        this.pizzas.addAll(pizzas);
        return this;
    }

    public PizzaOrder build() {
        PizzaOrder order = new PizzaOrder();
        for (Pizza pizza : pizzas) {
            order.addPizza(pizza);
        }
        return order;
    }
}
