package nl.brighton.systeminfoapi;

import static nl.brighton.systeminfoapi.util.HTTPUtils.sendGET;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.util.IntegrationTestStartup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;

@Tag("integration-test")
@ExtendWith(IntegrationTestStartup.class)
class ProcessResourceIT {

  @Test
  void getProcessInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET("http://localhost:7070/system-info/process",
        ProcessInfoCollection.class).getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getProcessInfoReturnsObjectOfTypeCPUInfoDTO() {
    ProcessInfoCollection expected = new ProcessInfoCollection();
    ProcessInfoCollection result = (ProcessInfoCollection) sendGET(
        "http://localhost:7070/system-info/process",
        ProcessInfoCollection.class).getBody();
    assertEquals(expected.getClass(), result.getClass());
  }
}