package be.pizza.kata.controller;

import be.pizza.kata.enitity.PizzaOrder;
import be.pizza.kata.request.OrderRequest;
import be.pizza.kata.response.OrderResponse;
import be.pizza.kata.service.DeliveryTimeEstimatorService;
import be.pizza.kata.service.PizzaOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public OrderResponse placeOrder(@RequestBody OrderRequest request) {
        PizzaOrder order = pizzaOrderService.createOrder(request.getPizza(), request.getSize());
        String estimatedTime = request.getToppings() != null ?
                deliveryTimeEstimatorService.estimateDeliveryTime(request.getToppings()) :
                deliveryTimeEstimatorService.estimateDeliveryTime();

        return new OrderResponse(order.getId().toString(), estimatedTime);
    }
}
