import entities.Order;
import status.OrderStatus;
import strategy.PaymentStrategy;

public class ECommerce{
  private PaymentStrategy paymentMethod;

  public void setPaymentMethod(PaymentStrategy paymentMethod) {
    this.paymentMethod = paymentMethod;
    paymentMethod.getPaymentDetails();
  }

  public boolean makePayment(Order order){
    if (this.paymentMethod != null) {
      try {
        if (this.paymentMethod.processPayment(order)) {
          order.setOrderStatus(OrderStatus.WAITING_FOR_SHIPMENT);
        }
      } catch (Exception e) {
        System.out.println("\nError processing payment: " + e.getMessage());
        order.setOrderStatus(OrderStatus.CANCELLED);
      }
    }
    return false;
  }   

}
