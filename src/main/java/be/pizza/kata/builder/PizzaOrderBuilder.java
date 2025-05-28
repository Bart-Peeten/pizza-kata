package be.pizza.kata.builder;

import be.pizza.kata.domain.PizzaOrder;

public class PizzaOrderBuilder {

    private String pizza;
    private String size;

    public PizzaOrderBuilder withPizza(String pizza) {
        this.pizza = pizza;
        return this;
    }

    public PizzaOrderBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaOrder build() {
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizza(pizza);
        pizzaOrder.setSize(size);
        return pizzaOrder;
    }
}
