package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;

public interface DiskService {

  DiskInfoCollection getAllDiskInfo();

  DiskInfoDTO getDiskInfo(String name);
}
