package strategy;

import entities.Order;

public interface PaymentStrategy {
  boolean processPayment(Order order);
  void getPaymentDetails();
  boolean paymentDetailsIsValid(Double amount);
}
