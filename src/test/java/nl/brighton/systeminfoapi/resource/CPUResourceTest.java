package nl.brighton.systeminfoapi.resource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.CPUInfoDTO;
import nl.brighton.systeminfoapi.service.CPUService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class CPUResourceTest {

  private CPUService mockedService;
  private CPUResource sut;

  @BeforeEach
  void setUp() {
    sut = new CPUResource();
    mockedService = mock(CPUService.class);
    when(mockedService.getCPUInfo()).thenReturn(new CPUInfoDTO(0, 0, null));
    sut.setService(mockedService);
  }

  @Test
  void getCPUInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getCPUInfo().getStatusCode();
    Assertions.assertEquals(expected, result);
  }

  @Test
  void getCPUInfoReturnsObjectOfTypeCPUInfoDTO() {
    CPUInfoDTO expected = new CPUInfoDTO(0, 0, null);
    CPUInfoDTO result = sut.getCPUInfo().getBody();
    Assertions.assertEquals(expected, result);
  }

  @Test
  void getCPUInfoUsesService() {
    sut.getCPUInfo();
    verify(mockedService).getCPUInfo();
  }
}