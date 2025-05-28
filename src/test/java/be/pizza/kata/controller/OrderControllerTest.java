package be.pizza.kata.controller;

import be.pizza.kata.domain.PizzaOrder;
import be.pizza.kata.repository.PizzaOrderRepository;
import be.pizza.kata.request.OrderRequest;
import be.pizza.kata.response.OrderResponse;
import be.pizza.kata.service.PizzaOrderService;
import be.pizza.kata.service.impl.DefaultDeliveryTimeEstimatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    public static final UUID uuid = UUID.randomUUID();

    private OrderRequest orderRequest;
    private DefaultDeliveryTimeEstimatorService deliveryTimeEstimatorService;

    @Mock
    PizzaOrder pizzaOrder;
    @Mock
    private PizzaOrderService pizzaOrderService;
    @Mock
    private PizzaOrderRepository pizzaOrderRepository;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        deliveryTimeEstimatorService = Mockito.spy(new DefaultDeliveryTimeEstimatorService(pizzaOrderRepository));
        orderController = new OrderController(deliveryTimeEstimatorService, pizzaOrderService);
    }

    @Test
    void testPlaceOrder() {
        orderRequest = new OrderRequest();
        orderRequest.setPizza("MARGHERITA");
        orderRequest.setSize("MEDIUM");

        when(pizzaOrderService.createOrder(orderRequest.getPizza(), orderRequest.getSize())).thenReturn(pizzaOrder);
        when(pizzaOrder.getId()).thenReturn(uuid);
        when(deliveryTimeEstimatorService.estimateDeliveryTime(uuid)).thenReturn("20 minutes");

        final OrderResponse result = orderController.placeOrder(orderRequest);

        assertEquals("20 minutes", result.getEstimatedTime());
    }

}