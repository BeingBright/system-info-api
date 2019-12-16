package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "disk")
public class DiskResource {

    @Autowired
    private DiskService service;

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiskInfoCollection> getAllDiskInfo() {
        return ResponseEntity.ok(service.getAllDiskInfo());
    }

    @ResponseBody
    @RequestMapping(path = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiskInfoDTO> getDiskInfo(@PathVariable String name) {
        return ResponseEntity.ok(service.getDiskInfo(name));
    }

    public void setService(DiskService service) {
        this.service = service;
    }
}
