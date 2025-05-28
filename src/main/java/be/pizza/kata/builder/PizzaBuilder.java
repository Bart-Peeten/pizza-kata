package be.pizza.kata.builder;

import be.pizza.kata.domain.Pizza;
import be.pizza.kata.domain.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {

    private String type;
    private String size;
    private List<Topping> toppings = new ArrayList<>();

    public PizzaBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PizzaBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder withToppings(List<Topping> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public Pizza build() {
        Pizza pizza = new Pizza(type, size);
        toppings.forEach(pizza::addTopping);
        return pizza;
    }
}
