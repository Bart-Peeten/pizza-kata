package be.pizza.kata.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

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

    public Pizza() {}

    public Pizza(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public int calculatePreparationTime() {
        return BASE_TIME;
    }
}
