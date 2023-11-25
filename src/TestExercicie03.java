import entities.Order;
import entities.PixPayment;
import entities.ProductDesk;
import entities.ProductNotebook;
import entities.ShoopingCart;
import entities.base.Service;
import observer.LogisticsAgent;
import status.OrderStatus;
import strategy.CartItemStrategy;

public class TestExercicie03 {
  public static void main(String[] args) {
    ECommerce ecommerce = new ECommerce();
    ShoopingCart cart = ShoopingCart.INSTANCE;
    Order order = null;

    LogisticsAgent logisticsAgent = new LogisticsAgent();

    CartItemStrategy item01 = new ProductNotebook("Macbook Air", 10.000, 5.0, "M3", 8);
    CartItemStrategy item02 = new ProductDesk("Genius Desk", 5.000, 2.0, "Madeira Naval", "1mx2m");
    CartItemStrategy item03 = new Service("Netflix", 2.5, 50);

    cart.addItem(item01);
    cart.addItem(item02);
    cart.addItem(item03);

    try {
        order = cart.confirmOrder();
        if (order != null) {
            order.attachObserver(logisticsAgent);
            try {
                Thread.sleep(3000);
                ecommerce.setPaymentMethod(new PixPayment());
                ecommerce.makePayment(order);

                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.SHIPPED);

                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.DELIVERED);

                Thread.sleep(3000);
                order.setOrderStatus(OrderStatus.CANCELLED);

            } catch (Exception e) {
                System.out.println("Error making payment: " + e.getMessage());
            }
        } else {
            throw new Exception("Error: Order is null.");
        }
    } catch (Exception e) {
        System.out.println("Error confirming order: " + e.getMessage());
        return;
    }
  }
}