package nl.brighton.systeminfoapi.dto;

import java.util.ArrayList;
import java.util.Objects;

public class NetworkInfoCollection {

    ArrayList<NetworkInfoDTO> networkInfos;

    public NetworkInfoCollection(ArrayList<NetworkInfoDTO> networkInfos) {
        this.networkInfos = networkInfos;
    }

    public ArrayList<NetworkInfoDTO> getNetworkInfos() {
        return networkInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
}
