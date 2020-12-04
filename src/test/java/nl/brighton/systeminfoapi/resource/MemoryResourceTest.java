package nl.brighton.systeminfoapi.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;
import nl.brighton.systeminfoapi.service.MemoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Tag("unit-test")
class MemoryResourceTest {

  private MemoryService mockedService;
  private MemoryResource sut;

  @BeforeEach
  void setUp() {
    sut = new MemoryResource();
    mockedService = mock(MemoryService.class);
    when(mockedService.getMemoryInfo()).thenReturn(new MemoryInfoDTO(0, 0, 0, null));
    sut.setService(mockedService);
  }

  @Test
  void getMemoryInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getMemoryInfo().getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getMemoryInfoReturnsObjectOfTypeCPUInfoDTO() {
    MemoryInfoDTO expected = new MemoryInfoDTO(0, 0, 0, null);
    MemoryInfoDTO result = sut.getMemoryInfo().getBody();
    assertEquals(expected, result);
  }

  @Test
  void getMemoryInfoUsesService() {
    sut.getMemoryInfo();
    verify(mockedService).getMemoryInfo();
  }
}