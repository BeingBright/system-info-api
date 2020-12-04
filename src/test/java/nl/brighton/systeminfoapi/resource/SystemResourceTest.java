package nl.brighton.systeminfoapi.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import nl.brighton.systeminfoapi.service.SystemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class SystemResourceTest {

  private SystemService mockedService;
  private SystemResource sut;


  @BeforeEach
  void setUp() {
    sut = new SystemResource();
    mockedService = mock(SystemService.class);
    when(mockedService.getSystemInfo())
        .thenReturn(new SystemInfoDTO("", "", "", "", "", ""));
    sut.setService(mockedService);
  }

  @Test
  void getSystemInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getSystemInfo().getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getSystemInfoReturnsObjectOfTypeCPUInfoDTO() {
    SystemInfoDTO expected = new SystemInfoDTO("", "", "", "", "", "");
    SystemInfoDTO result = sut.getSystemInfo().getBody();
    assertEquals(expected, result);
  }

  @Test
  void getSystemInfoUsesService() {
    sut.getSystemInfo();
    verify(mockedService).getSystemInfo();
  }

}