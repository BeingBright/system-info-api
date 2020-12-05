package nl.brighton.systeminfoapi.service;

import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;
import nl.brighton.systeminfoapi.dto.PhysicalMemoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.hardware.GlobalMemory;

@Service
public class MemoryServiceImpl implements MemoryService {

  private SystemTelemetryService service;

  @Autowired
  public void setService(SystemTelemetryService service) {
    this.service = service;
  }

  @Override
  public MemoryInfoDTO getMemoryInfo() {
    GlobalMemory memory = service.getMemory();
    ArrayList<PhysicalMemoryDTO> physicalMemoryDTOS = new ArrayList<>();
    for (var mem : memory.getPhysicalMemory()) {
      physicalMemoryDTOS.add(
          new PhysicalMemoryDTO(
              mem.getBankLabel().trim(),
              mem.getCapacity(),
              mem.getClockSpeed(),
              mem.getManufacturer().trim(),
              mem.getMemoryType().trim()
          )
      );
    }

    return new MemoryInfoDTO(memory.getTotal(), memory.getAvailable(), memory.getPageSize(),
        physicalMemoryDTOS);
  }
}
