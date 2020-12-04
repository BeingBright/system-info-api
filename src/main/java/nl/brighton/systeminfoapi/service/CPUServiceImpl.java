package nl.brighton.systeminfoapi.service;

import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.CPUCoreDTO;
import nl.brighton.systeminfoapi.dto.CPUInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

@Service
public class CPUServiceImpl implements CPUService {


  private SystemTelemetryService service;

  @Autowired
  public void setService(SystemTelemetryService service) {
    this.service = service;
  }

  @Override
  public CPUInfoDTO getCPUInfo() {
    CentralProcessor centralProcessor = new SystemInfo().getHardware().getProcessor();

    ArrayList<CPUCoreDTO> cores = new ArrayList<>();
    int i = 0;
    for (long freq : centralProcessor.getCurrentFreq()) {
      int coreID = i / (centralProcessor.getLogicalProcessorCount() / centralProcessor
          .getPhysicalProcessorCount());
      cores.add(new CPUCoreDTO(freq, coreID, i));
      i++;
    }

    return new CPUInfoDTO(centralProcessor.getLogicalProcessorCount(),
        centralProcessor.getMaxFreq(), cores);
  }
}
