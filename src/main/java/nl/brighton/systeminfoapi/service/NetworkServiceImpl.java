package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.dto.NetworkInfoDTO;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

import java.util.ArrayList;

@Service
public class NetworkServiceImpl implements NetworkService {
    @Override
    public NetworkInfoCollection getNetworkInfo() {
        NetworkIF[] networkIFs = new SystemInfo().getHardware().getNetworkIFs();
        ArrayList<NetworkInfoDTO> networkInfos = new ArrayList<>();
        for (NetworkIF networkIF : networkIFs) {
            networkInfos.add(new NetworkInfoDTO(
                    networkIF.getDisplayName(),
                    networkIF.getIPv4addr(),
                    networkIF.getIPv6addr(),
                    networkIF.getBytesSent(),
                    networkIF.getBytesRecv(),
                    networkIF.getPacketsSent(),
                    networkIF.getPacketsRecv()
            ));
        }
        return new NetworkInfoCollection(networkInfos);
    }
}
