package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {


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
