package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.AvailableMemoryDTO;
import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;
import nl.brighton.systeminfoapi.dto.PhysicalMemoryDTO;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

import java.util.ArrayList;

@Service
public class MemoryServiceImpl implements MemoryService {
    @Override
    public MemoryInfoDTO getMemoryInfo() {
        GlobalMemory memory = new SystemInfo().getHardware().getMemory();
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

        return new MemoryInfoDTO(memory.getTotal(), memory.getAvailable(), memory.getPageSize(), physicalMemoryDTOS);
    }

    @Override
    public AvailableMemoryDTO getAvailableMemory() {
        GlobalMemory memory = new SystemInfo().getHardware().getMemory();
        return new AvailableMemoryDTO(memory.getAvailable());
    }
}
