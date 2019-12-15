package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.dto.ProcessInfoDTO;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Override
    public ProcessInfoCollection getProcess() {
        OperatingSystem operatingSystem = new SystemInfo().getOperatingSystem();

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
