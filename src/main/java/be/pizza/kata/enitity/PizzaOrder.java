
package be.pizza.kata.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class PizzaOrder {

    private static final int BASE_TIME = 20;
    private static final int TIME_PER_TOPPING = 2;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "pizza", nullable = false)
    private String pizza;
    @Column(name = "size", nullable = false)
    private String size;

    public String estimateDeliveryTime() {
        return  BASE_TIME + " minutes";
    }

}
