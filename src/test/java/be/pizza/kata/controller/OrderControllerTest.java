package be.pizza.kata.controller;

import be.pizza.kata.enitity.PizzaOrder;
import be.pizza.kata.request.OrderRequest;
import be.pizza.kata.response.OrderResponse;
import be.pizza.kata.service.PizzaOrderService;
import be.pizza.kata.service.impl.DefaultDeliveryTimeEstimatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    public static final UUID uuid = UUID.randomUUID();

    private OrderRequest orderRequest;

    @Mock
    PizzaOrder pizzaOrder;
    @Mock
    private PizzaOrderService pizzaOrderService;
    @Spy
    private DefaultDeliveryTimeEstimatorService deliveryTimeEstimatorService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testPlaceOrder() {
        orderRequest = new OrderRequest();
        orderRequest.setPizza("MARGHERITA");
        orderRequest.setSize("MEDIUM");

        when(pizzaOrderService.createOrder(orderRequest.getPizza(), orderRequest.getSize())).thenReturn(pizzaOrder);
        when(pizzaOrder.getId()).thenReturn(uuid);
        when(deliveryTimeEstimatorService.estimateDeliveryTime()).thenCallRealMethod();

        final OrderResponse result = orderController.placeOrder(orderRequest);

        assertEquals("20 minutes", result.getEstimatedTime());
    }

    @Test
    void testPlaceOrderWithTopping() {
        orderRequest = new OrderRequest();
        orderRequest.setPizza("MARGHERITA");
        orderRequest.setSize("MEDIUM");
        final List<String> toppings = List.of("OLIVES");
        orderRequest.setToppings(toppings);

        when(pizzaOrderService.createOrder(orderRequest.getPizza(), orderRequest.getSize())).thenReturn(pizzaOrder);
        when(pizzaOrder.getId()).thenReturn(uuid);
        when(deliveryTimeEstimatorService.estimateDeliveryTime(toppings)).thenCallRealMethod();

        final OrderResponse result = orderController.placeOrder(orderRequest);

        assertEquals("22 minutes", result.getEstimatedTime());
    }

    @Test
    void testPlaceOrderWithMultipleToppings() {
        orderRequest = new OrderRequest();
        orderRequest.setPizza("MARGHERITA");
        orderRequest.setSize("MEDIUM");
        final List<String> toppings = List.of("OLIVES", "EXTRA_CHEESE");
        orderRequest.setToppings(toppings);

        when(pizzaOrderService.createOrder(orderRequest.getPizza(), orderRequest.getSize())).thenReturn(pizzaOrder);
        when(pizzaOrder.getId()).thenReturn(uuid);
        when(deliveryTimeEstimatorService.estimateDeliveryTime(toppings)).thenCallRealMethod();

        final OrderResponse result = orderController.placeOrder(orderRequest);

        assertEquals("24 minutes", result.getEstimatedTime());
    }

}