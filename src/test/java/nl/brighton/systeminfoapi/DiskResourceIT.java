package nl.brighton.systeminfoapi;

import static nl.brighton.systeminfoapi.util.HTTPUtils.sendGET;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.util.IntegrationTestStartup;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Tag("integration-test")
@ExtendWith(IntegrationTestStartup.class)
class DiskResourceIT {

  @Test
  void getAllDiskInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET("http://localhost:8080/system-info/disk", DiskInfoCollection.class)
        .getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getAllDiskInfoReturnsObjectOfTypeDiskInfoDTO() {
    DiskInfoCollection expected = new DiskInfoCollection(null);
    DiskInfoCollection result = (DiskInfoCollection) sendGET(
        "http://localhost:8080/system-info/disk", DiskInfoCollection.class).getBody();
    assertEquals(expected.getClass(), result.getClass());
  }

  @Test
  void getDiskInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sendGET("http://localhost:8080/system-info/disk/d",
        DiskInfoCollection.class)
        .getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getDiskInfoReturnsObjectOfTypeDiskInfoDTO() {
    DiskInfoDTO expected = new DiskInfoDTO("", 0, 0, 0);
    DiskInfoDTO result = (DiskInfoDTO) sendGET("http://localhost:8080/system-info/disk/d",
        DiskInfoDTO.class).getBody();
    assertEquals(expected.getClass(), result.getClass());
  }

  @Test
  void getDiskInfoThrows404StatusCode() {
    try {
      sendGET("http://localhost:8080/system-info/disk/no",
          DiskInfoDTO.class);
    } catch (HttpClientErrorException e) {
      HttpStatus expected = HttpStatus.NOT_FOUND;
      HttpStatus result = e.getStatusCode();
      assertEquals(expected, result);
    }
  }
}

//