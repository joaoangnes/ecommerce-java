package entities;

import entities.base.AbstractProduct;

public class ProductDesk extends AbstractProduct{
  private String material;
  private String dimensions;

  public ProductDesk(String productName, Double productPrice, Double productQuantity, String material, String dimensions) {
    super(productName, productPrice, productQuantity);
    this.material = material;
    this.dimensions = dimensions;
  }

  @Override
  public void printItemInfo() {
    System.out.println("Desk ID: " + getProductId());
    System.out.println("Desk Name: " + getProductName());
    System.out.println("Desk Price: $" + getProductPrice());
    System.out.println("Desk Quantity: " + getProductQuantity());
    System.out.println("Desk Material: " + this.material);
    System.out.println("Desk Dimensions: " + this.dimensions);
    System.out.println("----------------------------------------");
  }

  public String getMaterial() {
    return material;
  }

  public String getDimensions() {
    return dimensions;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setDimensions(String dimensions) {
    this.dimensions = dimensions;
  }
}
