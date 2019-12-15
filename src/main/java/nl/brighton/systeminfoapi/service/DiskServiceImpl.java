package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DiskServiceImpl implements DiskService {

    @Override
    public DiskInfoCollection getDiskInfo() {
        DiskInfoCollection infoCollection = new DiskInfoCollection();
        File[] roots = File.listRoots();

        for (File root : roots) {
            infoCollection.add(
                    new DiskInfoDTO(
                            root.getAbsolutePath(),
                            root.getTotalSpace(),
                            root.getFreeSpace(),
                            root.getUsableSpace()
                    )
            );
        }
        return infoCollection;
    }
}
