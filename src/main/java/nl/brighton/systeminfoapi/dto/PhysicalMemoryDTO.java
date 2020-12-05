package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class PhysicalMemoryDTO {

  private String bankLabel;
  private long capacity;
  private long clockSpeed;
  private String manufacturer;
  private String memoryType;

  public PhysicalMemoryDTO() {
  }

  public PhysicalMemoryDTO(String bankLabel, long capacity, long clockSpeed, String manufacturer,
      String memoryType) {
    this.bankLabel = bankLabel;
    this.capacity = capacity;
    this.clockSpeed = clockSpeed;
    this.manufacturer = manufacturer;
    this.memoryType = memoryType;
  }

  public String getBankLabel() {
    return bankLabel;
  }

  public void setBankLabel(String bankLabel) {
    this.bankLabel = bankLabel;
  }

  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }

  public long getClockSpeed() {
    return clockSpeed;
  }

  public void setClockSpeed(long clockSpeed) {
    this.clockSpeed = clockSpeed;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getMemoryType() {
    return memoryType;
  }

  public void setMemoryType(String memoryType) {
    this.memoryType = memoryType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhysicalMemoryDTO that = (PhysicalMemoryDTO) o;
    return clockSpeed == that.clockSpeed &&
        Objects.equals(bankLabel, that.bankLabel) &&
        Objects.equals(capacity, that.capacity) &&
        Objects.equals(manufacturer, that.manufacturer) &&
        Objects.equals(memoryType, that.memoryType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankLabel, capacity, clockSpeed, manufacturer, memoryType);
  }

  @Override
  public String toString() {
    return "PhysicalMemoryDTO{" +
        "bankLabel='" + bankLabel + '\'' +
        ", capacity='" + capacity + '\'' +
        ", clockSpeed=" + clockSpeed +
        ", manufacturer='" + manufacturer + '\'' +
        ", memoryType='" + memoryType + '\'' +
        '}';
  }
}
