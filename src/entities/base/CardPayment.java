package entities.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import strategy.PaymentStrategy;

public abstract class CardPayment implements PaymentStrategy{
  protected final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
  protected String cardName;
  protected String cardNumber;
  protected String expirtyDate;
  protected Integer cvv;
 
  public String getCardName() {
    return cardName;
  }
  public String getCardNumber() {
    return cardNumber;
  }
  public String getExpirtyDate() {
    return expirtyDate;
  }
  public Integer getCvv() {
    return cvv;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public void setExpirtyDate(String expirtyDate) {
    this.expirtyDate = expirtyDate;
  }
  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  @Override
  public boolean paymentDetailsIsValid(Double amount) {
    if (getCardName().isEmpty() || getCardNumber().isEmpty() || getExpirtyDate().isEmpty() || getCvv() == 0) {
      throw new IllegalArgumentException("Please fill in all the fields on the card.");
    }

    if (amount < 0) {
      throw new IllegalArgumentException("This payment cannot be processed");
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
    try {
      Date expiry = dateFormat.parse(getExpirtyDate());
      Date currentDate = new Date();

      if (expiry.before(currentDate)) {
        throw new IllegalArgumentException("The card's expiration date is invalid.");
      }
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid date format for the expiration date.");
    }
    return true;
  }
}