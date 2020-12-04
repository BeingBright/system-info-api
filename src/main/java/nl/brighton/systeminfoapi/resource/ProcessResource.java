package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "process")
public class ProcessResource {

  private ProcessService service;

  @ResponseBody
  @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProcessInfoCollection> getProcessInfo() {
    return ResponseEntity.ok(service.getProcess());
  }

  @Autowired
  public void setService(ProcessService service) {
    this.service = service;
  }
}
