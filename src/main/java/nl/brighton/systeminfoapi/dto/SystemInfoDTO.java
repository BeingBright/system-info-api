package nl.brighton.systeminfoapi.dto;

import java.util.Objects;

public class SystemInfoDTO {

  private String osName;
  private String osArch;
  private String osVersion;

  private String javaVersion;
  private String javaVMVersion;
  private String javaVMName;

  public SystemInfoDTO() {
  }

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

  public void setOsName(String osName) {
    this.osName = osName;
  }

  public String getOsArch() {
    return osArch;
  }

  public void setOsArch(String osArch) {
    this.osArch = osArch;
  }

  public String getOsVersion() {
    return osVersion;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public void setJavaVersion(String javaVersion) {
    this.javaVersion = javaVersion;
  }

  public String getJavaVMVersion() {
    return javaVMVersion;
  }

  public void setJavaVMVersion(String javaVMVersion) {
    this.javaVMVersion = javaVMVersion;
  }

  public String getJavaVMName() {
    return javaVMName;
  }

  public void setJavaVMName(String javaVMName) {
    this.javaVMName = javaVMName;
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
