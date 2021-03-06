package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class DiskInfoDTO {

  private String absolutePath;
  private long totalSpace;
  private long freeSpace;
  private long usableSpace;

  public DiskInfoDTO() {
  }

  public DiskInfoDTO(String absolutePath, long totalSpace, long freeSpace, long usableSpace) {
    this.absolutePath = absolutePath;
    this.totalSpace = totalSpace;
    this.freeSpace = freeSpace;
    this.usableSpace = usableSpace;
  }

  public DiskInfoDTO(String absolutePath) {
    this.absolutePath = absolutePath;
  }

  public String getAbsolutePath() {
    return absolutePath;
  }

  public void setAbsolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
  }

  public long getTotalSpace() {
    return totalSpace;
  }

  public void setTotalSpace(long totalSpace) {
    this.totalSpace = totalSpace;
  }

  public long getFreeSpace() {
    return freeSpace;
  }

  public void setFreeSpace(long freeSpace) {
    this.freeSpace = freeSpace;
  }

  public long getUsableSpace() {
    return usableSpace;
  }

  public void setUsableSpace(long usableSpace) {
    this.usableSpace = usableSpace;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiskInfoDTO that = (DiskInfoDTO) o;
    return Objects.equals(absolutePath, that.absolutePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(absolutePath, totalSpace, freeSpace, usableSpace);
  }

  @Override
  public String toString() {
    return "MemoryInfoDTO{" +
        "absolutePath='" + absolutePath + '\'' +
        ", totalSpace=" + totalSpace +
        ", freeSpace=" + freeSpace +
        ", usableSpace=" + usableSpace +
        '}';
  }
}
