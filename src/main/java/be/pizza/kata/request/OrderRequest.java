package be.pizza.kata.request;

import java.util.List;

/**
 * Represents a request to order a pizza.
 * This class contains information about the type of pizza and its size.
 */
public class OrderRequest {

    private String pizza;
    private String size;
    private List<String> toppings;

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(final List<String> toppings) {
        this.toppings = toppings;
    }
}
