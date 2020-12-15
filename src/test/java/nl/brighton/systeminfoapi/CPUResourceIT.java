package nl.brighton.systeminfoapi;

import static nl.brighton.systeminfoapi.util.HTTPUtils.sendGET;

import nl.brighton.systeminfoapi.dto.CPUInfoDTO;
import nl.brighton.systeminfoapi.util.IntegrationTestStartup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Tag("integration-test")
@ExtendWith(IntegrationTestStartup.class)
class CPUResourceIT {


  @Test
  void getCPUInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET(
        "http://localhost:7070/system-info/cpu", CPUInfoDTO.class).getStatusCode();
    Assertions.assertEquals(expected, result);
  }

  @Test
  void getCPUInfoReturnsObjectOfTypeCPUInfoDTO() {
    CPUInfoDTO expected = new CPUInfoDTO(0, 0, null);
    CPUInfoDTO result = ((ResponseEntity<CPUInfoDTO>) sendGET(
        "http://localhost:7070/system-info/cpu", CPUInfoDTO.class)).getBody();
    Assertions.assertEquals(expected.getClass(), result.getClass());
  }

}