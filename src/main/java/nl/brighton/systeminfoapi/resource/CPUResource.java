package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.CPUInfoDTO;
import nl.brighton.systeminfoapi.service.CPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cpu")
public class CPUResource {

  private CPUService service;

  @ResponseBody
  @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CPUInfoDTO> getCPUInfo() {
    return ResponseEntity.ok(service.getCPUInfo());
  }

  @Autowired
  public void setService(CPUService service) {
    this.service = service;
  }
}
