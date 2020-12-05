package nl.brighton.systeminfoapi.dto;

import java.util.Arrays;
import java.util.Objects;

public class NetworkInfoDTO {

  private String name;
  private String[] IPv4;
  private String[] IPV6;
  private long bytesSent;
  private long bytesReceived;
  private long packetSent;
  private long packetReceived;

  public NetworkInfoDTO() {
  }

  public NetworkInfoDTO(String name, String[] IPv4, String[] IPV6, long bytesSent,
      long bytesReceived, long packetSent, long packetReceived) {
    this.name = name;
    this.IPv4 = IPv4;
    this.IPV6 = IPV6;
    this.bytesSent = bytesSent;
    this.bytesReceived = bytesReceived;
    this.packetSent = packetSent;
    this.packetReceived = packetReceived;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getIPv4() {
    return IPv4;
  }

  public void setIPv4(String[] IPv4) {
    this.IPv4 = IPv4;
  }

  public String[] getIPV6() {
    return IPV6;
  }

  public void setIPV6(String[] IPV6) {
    this.IPV6 = IPV6;
  }

  public long getBytesSent() {
    return bytesSent;
  }

  public void setBytesSent(long bytesSent) {
    this.bytesSent = bytesSent;
  }

  public long getBytesReceived() {
    return bytesReceived;
  }

  public void setBytesReceived(long bytesReceived) {
    this.bytesReceived = bytesReceived;
  }

  public long getPacketSent() {
    return packetSent;
  }

  public void setPacketSent(long packetSent) {
    this.packetSent = packetSent;
  }

  public long getPacketReceived() {
    return packetReceived;
  }

  public void setPacketReceived(long packetReceived) {
    this.packetReceived = packetReceived;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkInfoDTO that = (NetworkInfoDTO) o;
    return bytesSent == that.bytesSent &&
        bytesReceived == that.bytesReceived &&
        packetSent == that.packetSent &&
        packetReceived == that.packetReceived &&
        Objects.equals(name, that.name) &&
        Arrays.equals(IPv4, that.IPv4) &&
        Arrays.equals(IPV6, that.IPV6);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name, bytesSent, bytesReceived, packetSent, packetReceived);
    result = 31 * result + Arrays.hashCode(IPv4);
    result = 31 * result + Arrays.hashCode(IPV6);
    return result;
  }

  @Override
  public String toString() {
    return "NetworkInfoDTO{" +
        "name='" + name + '\'' +
        ", IPv4=" + Arrays.toString(IPv4) +
        ", IPV6=" + Arrays.toString(IPV6) +
        ", bytesSent=" + bytesSent +
        ", bytesReceived=" + bytesReceived +
        ", packetSent=" + packetSent +
        ", packetReceived=" + packetReceived +
        '}';
  }
}
