package nl.brighton.systeminfoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
import nl.brighton.systeminfoapi.dto.DiskInfoDTO;
import nl.brighton.systeminfoapi.service.exception.DiskNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit-test")
class DiskServiceImplTest {

  private DiskServiceImpl sut;
  private SystemTelemetryService mockedSystemTelemetryService;

  @BeforeEach
  void setUp() {
    mockedSystemTelemetryService = mock(SystemTelemetryService.class);
    when(mockedSystemTelemetryService.getRoots())
        .thenReturn(new File[]{new File("C:\\"), new File("D:\\\\")});
    sut = new DiskServiceImpl();
    sut.setService(mockedSystemTelemetryService);
  }

  @Test
  void testIfGetAllDiskInfoUsesService() {
    sut.getAllDiskInfo();
    verify(mockedSystemTelemetryService).getRoots();
  }

  @Test
  void testIfGetDiskUsesService() {
    sut.getDiskInfo("c");
    verify(mockedSystemTelemetryService).getRoots();
  }

  @Test
  void testIfGetAllDisksReturnsCorrectValue() {
    ArrayList<DiskInfoDTO> diskInfo = new ArrayList<>();
    diskInfo.add(new DiskInfoDTO("C:\\"));
    diskInfo.add(new DiskInfoDTO("D:\\"));

    var expected = new DiskInfoCollection(diskInfo);
    var result = sut.getAllDiskInfo();
    assertEquals(expected, result);
  }

  @Test
  void testIfGetDiskReturnsCorrectValue() {
    DiskInfoDTO expected = new DiskInfoDTO("C:\\", 0, 0, 0);
    DiskInfoDTO result = sut.getDiskInfo("c");
    assertEquals(expected, result);
  }

  @Test
  void testIfGetDiskThrowsCorrectError() {
    assertThrows(DiskNotFoundException.class, () -> sut.getDiskInfo("NO"));
  }


}