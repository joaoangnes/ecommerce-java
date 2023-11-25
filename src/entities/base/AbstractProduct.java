package entities.base;

import strategy.CartItemStrategy;
import java.util.UUID;

public abstract class AbstractProduct implements CartItemStrategy{
  private String productId;
  private String productName;
  protected Double productPrice;
  protected Double productQuantity;
  
  public AbstractProduct(String productName, Double productPrice, Double productQuantity){
    this.productId = UUID.randomUUID().toString();
    this.productName = productName;
    this.productPrice = productPrice;
    this.productQuantity = productQuantity;
  }

  @Override
  public Double calculatePrice() {
    return this.productPrice * this.productQuantity;
  }

  public String getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public Double getProductPrice() {
    return productPrice;
  }

  public Double getProductQuantity() {
    return productQuantity;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  public void setProductQuantity(Double productQuantity) {
    this.productQuantity = productQuantity;
  }



}
