package nl.brighton.systeminfoapi.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.DiskService;
import nl.brighton.systeminfoapi.service.exception.DiskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@Tag("unit-test")
class DiskResourceTest {

  private DiskService mockedService;
  private DiskResource sut;

  @BeforeEach
  void setUp() {
    sut = new DiskResource();
    mockedService = mock(DiskService.class);
    when(mockedService.getAllDiskInfo()).thenReturn(new DiskInfoCollection(null));
    when(mockedService.getDiskInfo("D")).thenReturn(new DiskInfoDTO("", 0, 0, 0));
    when(mockedService.getDiskInfo("NO")).thenThrow(new DiskNotFoundException("NO: not found"));
    sut.setService(mockedService);
  }

  @Test
  void getAllDiskInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getAllDiskInfo().getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getAllDiskInfoReturnsObjectOfTypeDiskInfoDTO() {
    DiskInfoCollection expected = new DiskInfoCollection(null);
    DiskInfoCollection result = sut.getAllDiskInfo().getBody();
    assertEquals(expected, result);
  }

  @Test
  void getAllDiskInfoUsesService() {
    sut.getAllDiskInfo();
    verify(mockedService).getAllDiskInfo();
  }

  @Test
  void getDiskInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getDiskInfo("D").getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getDiskInfoReturnsObjectOfTypeDiskInfoDTO() {
    DiskInfoDTO expected = new DiskInfoDTO("", 0, 0, 0);
    DiskInfoDTO result = sut.getDiskInfo("D").getBody();
    assertEquals(expected, result);
  }

  @Test
  void getDiskInfoUsesService() {
    sut.getDiskInfo("D");
    verify(mockedService).getDiskInfo(anyString());
  }
}