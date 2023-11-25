package entities;

import java.util.List;

import strategy.CartItemStrategy;

public class OrderManager {

  public Order createOrder(List<CartItemStrategy> items, Double totalPrice) {
    if (items.isEmpty()) {
      throw new IllegalArgumentException("It is not possible to create an order without products.");  
    } 
      
    Order order = new Order(items, totalPrice);
    System.out.println("Order created successfully id: " + order.getOrderId());
    return order;
  }
}
