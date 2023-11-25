package entities;

import entities.base.AbstractProduct;

public class ProductNotebook extends AbstractProduct {
  private String processor;
  private Integer ramSize;

  public ProductNotebook(String productName, Double productPrice, Double productQuantity, String processor, Integer ramSize) {
    super(productName, productPrice, productQuantity);
    this.processor = processor;
    this.ramSize = ramSize; 
  }

  @Override
  public void printItemInfo() {
    System.out.println("Notebook ID: " + getProductId());
    System.out.println("Notebook Name: " + getProductName());
    System.out.println("Notebook Price: $" + getProductPrice());
    System.out.println("Notebook Quantity: " + getProductQuantity());
    System.out.println("Notebook Processor: " + this.processor);
    System.out.println("Notebook Dimensions: " + this.ramSize);
    System.out.println("----------------------------------------");
  }

  public String getProcessor() {
    return processor;
  }

  public Integer getRamSize() {
    return ramSize;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public void setRamSize(Integer ramSize) {
    this.ramSize = ramSize;
  }

}
