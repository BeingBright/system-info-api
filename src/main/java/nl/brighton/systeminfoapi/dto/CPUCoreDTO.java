package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class CPUCoreDTO {

  private final long currentFrequency;
  private final int coreID;
  private final int processorNumber;

  public CPUCoreDTO(long currentFrequency, int coreID, int processorNumber) {
    this.currentFrequency = currentFrequency;
    this.coreID = coreID;
    this.processorNumber = processorNumber;
  }

  public long getCurrentFrequency() {
    return currentFrequency;
  }

  public int getProcessorNumber() {
    return processorNumber;
  }

  public int getCoreID() {
    return coreID;
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
