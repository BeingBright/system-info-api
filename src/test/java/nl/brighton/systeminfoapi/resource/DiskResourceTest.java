package nl.brighton.systeminfoapi.resource;

import static org.mockito.ArgumentMatchers.anyString;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.DiskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class DiskResourceTest {

  private DiskService mockedService;
  private DiskResource sut;

  @BeforeEach
  void setUp() {
    sut = new DiskResource();
    mockedService = Mockito.mock(DiskService.class);
    Mockito.when(mockedService.getAllDiskInfo()).thenReturn(new DiskInfoCollection(null));
    Mockito.when(mockedService.getDiskInfo(anyString())).thenReturn(new DiskInfoDTO("", 0, 0, 0));
    sut.setService(mockedService);
  }

  @Test
  void getAllDiskInfoReturnsStatusOK() {
    var expected = HttpStatus.OK;
    var result = sut.getAllDiskInfo();
    Assertions.assertEquals(expected, result.getStatusCode());
  }

  @Test
  void getAllDiskInfoReturnsObjectOfTypeCPUInfoDTO() {
    var expected = new DiskInfoCollection(null);
    var result = sut.getAllDiskInfo();
    Assertions.assertEquals(expected, result.getBody());
  }

  @Test
  void getAllDiskInfoUsesService() {
    sut.getAllDiskInfo();
    Mockito.verify(mockedService).getAllDiskInfo();
  }

  @Test
  void getDiskInfoReturnsStatusOK() {
    var expected = HttpStatus.OK;
    var result = sut.getDiskInfo("D");
    Assertions.assertEquals(expected, result.getStatusCode());
  }

  @Test
  void getDiskInfoReturnsObjectOfTypeCPUInfoDTO() {
    var expected = new DiskInfoDTO("", 0, 0, 0);
    var result = sut.getDiskInfo("D");
    Assertions.assertEquals(expected, result.getBody());
  }

  @Test
  void getDiskInfoUsesService() {
    sut.getDiskInfo("D");
    Mockito.verify(mockedService).getDiskInfo(anyString());
  }
}