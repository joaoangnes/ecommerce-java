import entities.ProductDesk;
import entities.ProductNotebook;
import entities.ShoopingCart;
import entities.base.Service;
import strategy.CartItemStrategy;
import java.util.List;

public class TestExercicie02 {
  public static void main(String[] args) {
    ShoopingCart cart = ShoopingCart.INSTANCE;
    List<CartItemStrategy> listItems = cart.getListItems();

    CartItemStrategy item01 = new ProductNotebook("Macbook Air", 10.000, 5.0, "M3", 8);
    CartItemStrategy item02 = new ProductDesk("Genius Desk", 5.000, 2.0, "Madeira Naval", "1mx2m");
    CartItemStrategy item03 = new Service("Netflix", 2.5, 50);

    cart.addItem(item01);
    cart.addItem(item02);
    cart.addItem(item03);

    for (CartItemStrategy item : listItems) {
      item.printItemInfo();
    }

    System.out.println("\n=====================");
    System.out.println("Removing the item 01");
    cart.removeItem(item01);

    for (CartItemStrategy item : listItems) {
      item.printItemInfo();
    }

  }
}
