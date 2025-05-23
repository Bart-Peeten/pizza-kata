package be.pizza.kata;

import be.pizza.kata.service.DeliveryTimeEstimatorService;
import be.pizza.kata.service.PizzaOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {

    private final DeliveryTimeEstimatorService deliveryTimeEstimatorService;
    private final PizzaOrderService pizzaOrderService;

    /**
     * Ctor to create a new instance of {@link OrderController}.
     *
     * @param deliveryTimeEstimatorService {@link DeliveryTimeEstimatorService} to use for estimating delivery time.
     * @param pizzaOrderService            {@link PizzaOrderService} to use for creating new orders.
     */
    public OrderController(final DeliveryTimeEstimatorService deliveryTimeEstimatorService, final PizzaOrderService pizzaOrderService) {
        this.deliveryTimeEstimatorService = deliveryTimeEstimatorService;
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostMapping("/order")
    public Map<String, String> placeOrder(@RequestBody Map<String, String> request) {
        String pizza = request.get("pizza");
        String size = request.get("size");

        PizzaOrder order = pizzaOrderService.createOrder(pizza, size);
        String estimatedTime = deliveryTimeEstimatorService.estimateDeliveryTime();

        Map<String, String> response = new HashMap<>();
        response.put("orderId", order.getId().toString());
        response.put("estimatedTime", estimatedTime);
        return response;
    }
}
