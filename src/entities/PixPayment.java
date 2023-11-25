package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import strategy.PaymentStrategy;

public class PixPayment implements PaymentStrategy{
  private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
  private String pixKey;
  private String pixOwnerName;

  @Override
  public boolean processPayment(Order order) {
    if (this.paymentDetailsIsValid(order.getTotalPrice())){
      System.out.println("\nProcessing pix payment, key '"+ this.pixKey +"' for " + order.getTotalPrice());
      return true;
    }

    return false;
  }

  @Override
  public void getPaymentDetails() {
    try {
          System.out.print("Enter your name: ");
          this.pixOwnerName = READER.readLine();
          System.out.print("Enter the pix key: ");
          this.pixKey = READER.readLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
  }

  @Override
  public boolean paymentDetailsIsValid(Double amount) {
    if (getPixKey().isEmpty() || getPixOwnerName().isEmpty()) {
      throw new IllegalArgumentException("Fill in all the fields requested to make the payment via Pix.");
    }

    if (amount < 0) {
      throw new IllegalArgumentException("This payment cannot be processed");
    }

    return true;
  }

  public BufferedReader getREADER() {
    return READER;
  }

  public String getPixKey() {
    return pixKey;
  }

  public String getPixOwnerName() {
    return pixOwnerName;
  }
  
}
