package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "disk")
public class DiskResource {

    @Autowired
    private DiskService service;

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiskInfoCollection> getDiskInfo() {
        return ResponseEntity.ok(service.getDiskInfo());
    }

    public void setService(DiskService service) {
        this.service = service;
    }
}
