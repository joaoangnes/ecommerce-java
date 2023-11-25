package entities;

import java.util.List;
import java.util.ArrayList;
import strategy.CartItemStrategy;

public enum ShoopingCart {
  INSTANCE;
  public List<CartItemStrategy> listItems;
  private OrderManager orderManager;
  
  // Anonymous constructor
  { 
    this.listItems = new ArrayList<>(); 
    this.orderManager = new OrderManager();
  }

  public void addItem(CartItemStrategy item) {
    this.listItems.add(item);
  }

  public void removeItem(CartItemStrategy item) {
    this.listItems.remove(item);
  }

  public double calculateTotalPrice() {
    double totalPrice = 0.0;
    for (CartItemStrategy item : this.listItems) {
        totalPrice += item.calculatePrice();
    }
    return totalPrice;
  }

  // Create a new Sales Order with the products add
  public Order confirmOrder() {
    try{
      double totalPrice = calculateTotalPrice();
      return this.orderManager.createOrder(this.listItems, totalPrice);
    } catch (Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  public List<CartItemStrategy> getListItems(){
    return this.listItems;
  }
}
