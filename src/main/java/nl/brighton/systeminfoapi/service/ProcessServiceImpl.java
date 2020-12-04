package nl.brighton.systeminfoapi.service;

import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.dto.ProcessInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.software.os.OperatingSystem;

@Service
public class ProcessServiceImpl implements ProcessService {

  private SystemTelemetryService service;

  @Autowired
  public void setService(SystemTelemetryService service) {
    this.service = service;
  }

  @Override
  public ProcessInfoCollection getProcess() {
    OperatingSystem operatingSystem = service.getSystem();

    ArrayList<ProcessInfoDTO> processes = new ArrayList<>();

    for (var process : operatingSystem.getProcesses()) {
      processes.add(new ProcessInfoDTO(
          process.getProcessID(),
          process.getName(),
          process.getKernelTime(),
          process.getParentProcessID(),
          process.getUserID(),
          process.getUpTime(),
          process.getPriority(),
          process.getBytesRead(),
          process.getBytesWritten(),
          process.getBitness()
      ));
    }
    return new ProcessInfoCollection(processes);
  }
}
