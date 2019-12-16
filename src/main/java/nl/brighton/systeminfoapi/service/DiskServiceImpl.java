package nl.brighton.systeminfoapi.service;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.exception.DiskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DiskServiceImpl implements DiskService {

    private SystemTelemetryService service;

    @Autowired
    public void setService(SystemTelemetryService service) {
        this.service = service;
    }

    @Override
    public DiskInfoCollection getAllDiskInfo() {
        DiskInfoCollection infoCollection = new DiskInfoCollection();
        File[] roots = service.getRoots();

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
        File[] roots = service.getRoots();
        if (name.matches("^[a-zA-Z]+$")) {
            for (File root : roots) {
                if (root.getAbsolutePath().toLowerCase().contains(name.toLowerCase())) {
                    return new DiskInfoDTO(
                            root.getAbsolutePath(),
                            root.getTotalSpace(),
                            root.getFreeSpace(),
                            root.getUsableSpace()

                    );
                }
            }
        }
        throw new DiskNotFoundException(name);
    }
}
