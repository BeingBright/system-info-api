package nl.brighton.systeminfoapi.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.service.ProcessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ProcessResourceTest {

  private ProcessService mockedService;
  private ProcessResource sut;

  @BeforeEach
  void setUp() {
    sut = new ProcessResource();
    mockedService = mock(ProcessService.class);
    when(mockedService.getProcess()).thenReturn(new ProcessInfoCollection(null));
    sut.setService(mockedService);
  }

  @Test
  void getProcessInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getProcessInfo().getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getProcessInfoReturnsObjectOfTypeCPUInfoDTO() {
    ProcessInfoCollection expected = new ProcessInfoCollection(null);
    ProcessInfoCollection result = sut.getProcessInfo().getBody();
    assertEquals(expected, result);
  }

  @Test
  void getProcessInfoUsesService() {
    sut.getProcessInfo();
    verify(mockedService).getProcess();
  }
}