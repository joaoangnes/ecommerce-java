package observer;

import entities.Order;
import status.OrderStatus;

public class LogisticsAgent implements OrderObserver {
    @Override
    public void update(Order order) {
        OrderStatus orderStatus = order.getOrderStatus();

        if (orderStatus.equals(OrderStatus.WAITING_FOR_SHIPMENT)) {
            System.out.println("Logistics Agent: Order " + order.getOrderId() + " is ready for shipment.");
        } else if (orderStatus.equals(OrderStatus.SHIPPED)) {
            System.out.println("Logistics Agent: Order " + order.getOrderId() + " has been shipped.");
        } else if (orderStatus.equals(OrderStatus.DELIVERED)) {
            System.out.println("Logistics Agent: Order " + order.getOrderId() + " has been delivered.");
        } else if (orderStatus.equals(OrderStatus.CANCELLED)) {
            System.out.println("Logistics Agent: Order " + order.getOrderId() + " has been cancelled, returning requested orders.");
        } else {
            System.out.println("Logistics Agent: Order " + order.getOrderId() + " has already been delivered.");
        }
    }
}