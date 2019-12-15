package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.exception.DiskNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DiskServiceImpl implements DiskService {

    @Override
    public DiskInfoCollection getAllDiskInfo() {
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

    @Override
    public DiskInfoDTO getDiskInfo(String name) {
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.getAbsolutePath().contains(name)) {
                return new DiskInfoDTO(
                        root.getAbsolutePath(),
                        root.getTotalSpace(),
                        root.getFreeSpace(),
                        root.getUsableSpace()

                );
            }
        }
        throw new DiskNotFoundException();
    }
}
