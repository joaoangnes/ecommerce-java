package observer;

public interface LogisticSubject {
  void attachObserver(OrderObserver observer);
  void detachObserver(OrderObserver observer);
  void notifyObservers();
}
