package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class DiskInfoDTO {

  private final String absolutePath;
  private final long totalSpace;
  private final long freeSpace;
  private final long usableSpace;

  public DiskInfoDTO(String absolutePath, long totalSpace, long freeSpace, long usableSpace) {
    this.absolutePath = absolutePath;
    this.totalSpace = totalSpace;
    this.freeSpace = freeSpace;
    this.usableSpace = usableSpace;
  }

  public DiskInfoDTO(String absolutePath) {
    this.absolutePath = absolutePath;
    this.totalSpace = 0;
    this.freeSpace = 0;
    this.usableSpace = 0;
  }

  public String getAbsolutePath() {
    return absolutePath;
  }

  public long getTotalSpace() {
    return totalSpace;
  }

  public long getFreeSpace() {
    return freeSpace;
  }

  public long getUsableSpace() {
    return usableSpace;
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
