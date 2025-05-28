package be.pizza.kata.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Pizza {

    private static final int BASE_TIME = 20;

    @Id
    @GeneratedValue
    private UUID id;

    private String type;
    private String size;

    @ElementCollection
    @CollectionTable(name = "pizza_toppings", joinColumns = @JoinColumn(name = "pizza_id"))
    private List<Topping> toppings = new ArrayList<>();

    public Pizza() {}

    public Pizza(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public int calculatePreparationTime() {
        return BASE_TIME + toppings.size() * 2;
    }

    public boolean isVegetarian() {
        return toppings.stream().noneMatch(t -> t.getName().equalsIgnoreCase("pepperoni") || t.getName().equalsIgnoreCase("ham"));
    }

    public boolean hasTopping(String name) {
        return toppings.stream().anyMatch(t -> t.getName().equalsIgnoreCase(name));
    }
}
