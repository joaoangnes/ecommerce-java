package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import strategy.CartItemStrategy;
import observer.LogisticSubject;
import observer.OrderObserver;
import status.OrderStatus;

public class Order implements LogisticSubject{
  private String orderId;
  private OrderStatus orderStatus;
  private List<CartItemStrategy> items;
  private Double totalPrice;
  private List<OrderObserver> observers;

  public Order(List<CartItemStrategy> items, Double totalPrice){
    this.orderId     = UUID.randomUUID().toString();
    this.orderStatus = OrderStatus.WAITING_PAYMENT;
    this.items       = items;
    this.totalPrice  = totalPrice;
    this.observers = new ArrayList<>();
  }

  public List<CartItemStrategy> getItems() {
    return items;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public String getOrderId() {
    return orderId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    if (orderStatus.equals(OrderStatus.CANCELLED) && this.orderStatus.equals(OrderStatus.DELIVERED)){
      System.out.println("It is not possible to cancel an order that has already been delivered");
      return;
    } 
    
    this.orderStatus = orderStatus;
    this.notifyObservers();
  }

  @Override
  public void attachObserver(OrderObserver observer) {
    this.observers.add(observer);
  }

  @Override
  public void detachObserver(OrderObserver observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (OrderObserver observer : observers) {
      observer.update(this);
    }
  }

}
