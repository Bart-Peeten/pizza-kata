package be.pizza.kata.response;

/**
 * Represents the response for an order, containing details about the order ID
 * and estimated time for completion or delivery.
 */
public class OrderResponse {

    private String orderId;
    private String estimatedTime;

    public OrderResponse(String orderId, String estimatedTime) {
        this.orderId = orderId;
        this.estimatedTime = estimatedTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
