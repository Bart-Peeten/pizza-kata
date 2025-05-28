package be.pizza.kata.builder;

import be.pizza.kata.domain.Pizza;

public class PizzaBuilder {

    private String type;
    private String size;

    public PizzaBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PizzaBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public Pizza build() {
        return new Pizza(type, size);
    }
}
