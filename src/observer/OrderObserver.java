package observer;

import entities.Order;

public interface OrderObserver {
  void update(Order order);
}
