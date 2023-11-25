package entities.base;

import strategy.CartItemStrategy;
import java.util.UUID;

public class Service implements CartItemStrategy{
  private String serviceId;
  private String serviceName;
  private Double serviceHourlyRate;
  private Integer serviceHoursHired;

  public Service(String serviceName, Double serviceHourlyRate, Integer serviceHoursHired) {
    this.serviceId = UUID.randomUUID().toString();
    this.serviceName = serviceName;
    this.serviceHourlyRate = serviceHourlyRate;
    this.serviceHoursHired = serviceHoursHired;
  }

  @Override
  public Double calculatePrice() {
    return this.serviceHourlyRate * this.serviceHoursHired;
  }

  @Override
  public void printItemInfo() {
    System.out.println("Service ID: " + serviceId);
    System.out.println("Service Name: " + serviceName);
    System.out.println("Hourly Rate: $" + serviceHourlyRate);
    System.out.println("Hours Hired: " + serviceHoursHired);
    System.out.println("Total Price: $" + calculatePrice());
    System.out.println("----------------------------------------");
  }

  public String getServiceId() {
    return serviceId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public Double getServiceHourlyRate() {
    return serviceHourlyRate;
  }

  public Integer getServiceHoursHired() {
    return serviceHoursHired;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public void setServiceHourlyRate(Double serviceHourlyRate) {
    this.serviceHourlyRate = serviceHourlyRate;
  }

  public void setServiceHoursHired(Integer serviceHoursHired) {
    this.serviceHoursHired = serviceHoursHired;
  }


  
}
