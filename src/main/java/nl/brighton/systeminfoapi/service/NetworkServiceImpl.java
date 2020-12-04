package nl.brighton.systeminfoapi.service;

import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.dto.NetworkInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.hardware.NetworkIF;

@Service
public class NetworkServiceImpl implements NetworkService {


  private SystemTelemetryService service;

  @Autowired
  public void setService(SystemTelemetryService service) {
    this.service = service;
  }

  @Override
  public NetworkInfoCollection getNetworkInfo() {
    NetworkIF[] networkIFs = service.getNetworkIfs();
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
