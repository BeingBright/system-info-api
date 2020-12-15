package nl.brighton.systeminfoapi;

import static nl.brighton.systeminfoapi.util.HTTPUtils.sendGET;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.util.IntegrationTestStartup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;

@Tag("integration-test")
@ExtendWith(IntegrationTestStartup.class)
class NetworkResourceIT {

  @Test
  void getNetworkInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET("http://localhost:7070/system-info/network",
        NetworkInfoCollection.class).getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getNetworkInfoReturnsObjectOfTypeCPUInfoDTO() {
    NetworkInfoCollection expected = new NetworkInfoCollection(null);
    NetworkInfoCollection result = (NetworkInfoCollection) sendGET(
        "http://localhost:7070/system-info/network",
        NetworkInfoCollection.class).getBody();
    assertEquals(expected.getClass(), result.getClass());
  }
}