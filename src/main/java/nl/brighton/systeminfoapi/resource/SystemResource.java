package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import nl.brighton.systeminfoapi.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "system")
public class SystemResource {

    @Autowired
    private SystemService service;

    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemInfoDTO> getSystemInfo() {
        return ResponseEntity.ok(service.getSystemInfo());
    }
}
