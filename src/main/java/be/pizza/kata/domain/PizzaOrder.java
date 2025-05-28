
package be.pizza.kata.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pizza_order_id")
    private List<Pizza> pizzas = new ArrayList<>();

    public String estimateDeliveryTime() {
        int total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.calculatePreparationTime();
        }
        return total + " minutes";
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
}
