package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class NetworkInfoCollection {

  private ArrayList<NetworkInfoDTO> networkInfos;

  public NetworkInfoCollection(ArrayList<NetworkInfoDTO> networkInfos) {
    this.networkInfos = networkInfos;
  }

  public NetworkInfoCollection() {
  }

  public ArrayList<NetworkInfoDTO> getNetworkInfos() {
    return networkInfos;
  }

  public void setNetworkInfos(
      ArrayList<NetworkInfoDTO> networkInfos) {
    this.networkInfos = networkInfos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkInfoCollection that = (NetworkInfoCollection) o;
    return Objects.equals(networkInfos, that.networkInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkInfos);
  }

  @Override
  public String toString() {
    return "NetworkInfoCollection{" +
        "networkInfos=" + networkInfos +
        '}';
  }

  public boolean add(NetworkInfoDTO networkInfoDTO) {
    return networkInfos.add(networkInfoDTO);
  }

  public boolean contains(NetworkInfoDTO networkInfoDTO) {
    return networkInfos.contains(networkInfoDTO);
  }

  public boolean remove(NetworkInfoDTO networkInfoDTO) {
    return networkInfos.remove(networkInfoDTO);
  }
}
