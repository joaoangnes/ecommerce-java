package entities;

import java.io.IOException;

import entities.base.CardPayment;

public class DebitCardPayment extends CardPayment {
  @Override
  public boolean processPayment(Order order) {
    if (this.paymentDetailsIsValid(order.getTotalPrice())){
      System.out.println("\nProcessing debit card payment for " + order.getTotalPrice());
      return true;  
    }

    return false;
  }

  @Override
  public void getPaymentDetails() {
    try {
          System.out.print("Enter the card name: ");
          setCardName(READER.readLine());
          System.out.print("Enter the card number: ");
          setCardNumber(READER.readLine());
          System.out.print("Enter the card expiration date 'mm/yy': ");
          setExpirtyDate(READER.readLine());
          System.out.print("Enter the CVV code: ");
          setCvv(Integer.parseInt(READER.readLine()));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
        
  }
}
