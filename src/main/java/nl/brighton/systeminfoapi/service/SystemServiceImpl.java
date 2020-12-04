package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {

  private SystemTelemetryService service;

  @Autowired
  public void setService(SystemTelemetryService service) {
    this.service = service;
  }

  @Override
  public SystemInfoDTO getSystemInfo() {
    return new SystemInfoDTO(
        System.getProperty("os.name"),
        System.getProperty("os.arch"),
        System.getProperty("os.version"),
        System.getProperty("java.version"),
        System.getProperty("java.vm.version"),
        System.getProperty("java.vm.name")
    );
  }
}
