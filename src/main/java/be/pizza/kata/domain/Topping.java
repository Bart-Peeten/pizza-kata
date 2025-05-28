package be.pizza.kata.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Topping {

    private String name;

    protected Topping() {
    }

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

