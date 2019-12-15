package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.AvailableMemoryDTO;
import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;

public interface MemoryService {

    MemoryInfoDTO getMemoryInfo();

    AvailableMemoryDTO getAvailableMemory();
}
