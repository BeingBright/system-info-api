package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class SystemInfoDTO {

  private final String osName;
  private final String osArch;
  private final String osVersion;

  private final String javaVersion;
  private final String javaVMVersion;
  private final String javaVMName;

  public SystemInfoDTO(String osName, String osArch, String osVersion, String javaVersion,
      String javaVMVersion, String javaVMName) {
    this.osName = osName;
    this.osArch = osArch;
    this.osVersion = osVersion;
    this.javaVersion = javaVersion;
    this.javaVMVersion = javaVMVersion;
    this.javaVMName = javaVMName;
  }

  public String getOsName() {
    return osName;
  }

  public String getOsArch() {
    return osArch;
  }

  public String getOsVersion() {
    return osVersion;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public String getJavaVMVersion() {
    return javaVMVersion;
  }

  public String getJavaVMName() {
    return javaVMName;
  }

  @Override
  public String toString() {
    return "SystemInfoDTO{" +
        "osName='" + osName + '\'' +
        ", osArch='" + osArch + '\'' +
        ", osVersion='" + osVersion + '\'' +
        ", javaVersion='" + javaVersion + '\'' +
        ", javaVMVersion='" + javaVMVersion + '\'' +
        ", javaVMName='" + javaVMName + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemInfoDTO that = (SystemInfoDTO) o;
    return Objects.equals(osName, that.osName) &&
        Objects.equals(osArch, that.osArch) &&
        Objects.equals(osVersion, that.osVersion) &&
        Objects.equals(javaVersion, that.javaVersion) &&
        Objects.equals(javaVMVersion, that.javaVMVersion) &&
        Objects.equals(javaVMName, that.javaVMName);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
