package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.AvailableMemoryDTO;
import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;
import nl.brighton.systeminfoapi.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "memory")
public class MemoryResource {

    @Autowired
    private MemoryService service;

    @ResponseBody
    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemoryInfoDTO> getMemoryInfo() {
        return ResponseEntity.ok(service.getMemoryInfo());
    }

    @ResponseBody
    @RequestMapping(path = "/available", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvailableMemoryDTO> getAvailableMemory() {
        return ResponseEntity.ok(service.getAvailableMemory());
    }

}
