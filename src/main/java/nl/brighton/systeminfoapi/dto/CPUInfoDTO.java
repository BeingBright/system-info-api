package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class CPUInfoDTO {

  private int numberOfCores;
  private long maxFrequency;
  private ArrayList<CPUCoreDTO> cores;

  public CPUInfoDTO(int numberOfCores, long maxFrequency, ArrayList<CPUCoreDTO> cores) {
    this.numberOfCores = numberOfCores;
    this.maxFrequency = maxFrequency;
    this.cores = cores;
  }

  public int getNumberOfCores() {
    return numberOfCores;
  }

  public long getMaxFrequency() {
    return maxFrequency;
  }

  public ArrayList<CPUCoreDTO> getCores() {
    return cores;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    CPUInfoDTO that = (CPUInfoDTO) o;
    return numberOfCores == that.numberOfCores &&
        maxFrequency == that.maxFrequency &&
        Objects.equals(cores, that.cores);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfCores, maxFrequency, cores);
  }

  @Override
  public String toString() {
    return "CPUInfoDTO{" +
        "numberOfCores=" + numberOfCores +
        ", maxFrequency=" + maxFrequency +
        ", cores=" + cores +
        '}';
  }
}

