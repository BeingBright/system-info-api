package nl.brighton.systeminfoapi;

import static nl.brighton.systeminfoapi.util.HTTPUtils.sendGET;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import nl.brighton.systeminfoapi.util.IntegrationTestStartup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;

@Tag("integration-test")
@ExtendWith(IntegrationTestStartup.class)
class SystemResourceIT {

  @Test
  void getSystemInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET("http://localhost:6060/system-info/system",
        SystemInfoDTO.class).getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getSystemInfoReturnsObjectOfTypeCPUInfoDTO() {
    SystemInfoDTO expected = new SystemInfoDTO("", "", "", "", "", "");
    SystemInfoDTO result = (SystemInfoDTO) sendGET("http://localhost:6060/system-info/system",
        SystemInfoDTO.class).getBody();
    assertEquals(expected.getClass(), result.getClass());
  }
}