package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class CPUCoreDTO {

  private long currentFrequency;
  private int coreID;
  private int processorNumber;

  public CPUCoreDTO() {
  }

  public CPUCoreDTO(long currentFrequency, int coreID, int processorNumber) {
    this.currentFrequency = currentFrequency;
    this.coreID = coreID;
    this.processorNumber = processorNumber;
  }

  public long getCurrentFrequency() {
    return currentFrequency;
  }

  public void setCurrentFrequency(long currentFrequency) {
    this.currentFrequency = currentFrequency;
  }

  public int getProcessorNumber() {
    return processorNumber;
  }

  public void setProcessorNumber(int processorNumber) {
    this.processorNumber = processorNumber;
  }

  public int getCoreID() {
    return coreID;
  }

  public void setCoreID(int coreID) {
    this.coreID = coreID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CPUCoreDTO that = (CPUCoreDTO) o;
    return currentFrequency == that.currentFrequency &&
        processorNumber == that.processorNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentFrequency, processorNumber);
  }

  @Override
  public String toString() {
    return "CPUCoreDTO{" +
        "currentFrequency=" + currentFrequency +
        ", coreID=" + coreID +
        ", processorNumber=" + processorNumber +
        '}';
  }
}
