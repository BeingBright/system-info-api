package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "network")
public class NetworkResource {

  @Autowired
  private NetworkService service;

  @ResponseBody
  @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<NetworkInfoCollection> getNetworkInfo() {
    return ResponseEntity.ok(service.getNetworkInfo());
  }

  public void setService(NetworkService service) {
    this.service = service;
  }
}
