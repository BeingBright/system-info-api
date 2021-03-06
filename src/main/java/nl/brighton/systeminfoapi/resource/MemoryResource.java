package nl.brighton.systeminfoapi.resource;

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

  private MemoryService service;


  @ResponseBody
  @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MemoryInfoDTO> getMemoryInfo() {
    return ResponseEntity.ok(service.getMemoryInfo());
  }

  @Autowired
  public void setService(MemoryService service) {
    this.service = service;
  }
}
