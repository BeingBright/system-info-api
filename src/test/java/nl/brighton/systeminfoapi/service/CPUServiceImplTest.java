package nl.brighton.systeminfoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import nl.brighton.systeminfoapi.dto.CPUCoreDTO;
import nl.brighton.systeminfoapi.dto.CPUInfoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import oshi.hardware.CentralProcessor;

@Tag("unit-test")
class CPUServiceImplTest {

  private CPUServiceImpl sut;
  private SystemTelemetryService mockedSystemTelemetryService;
  private CentralProcessor mockedCentralProcessor;

  @BeforeEach
  void setUp() {
    sut = new CPUServiceImpl();
    mockedSystemTelemetryService = mock(SystemTelemetryService.class);
    mockedCentralProcessor = mock(CentralProcessor.class);
    when(mockedCentralProcessor.getLogicalProcessorCount()).thenReturn(4);
    when(mockedCentralProcessor.getPhysicalProcessorCount()).thenReturn(2);
    when(mockedCentralProcessor.getCurrentFreq()).thenReturn(new long[]{10l, 10l, 10l, 10l});
    when(mockedCentralProcessor.getMaxFreq()).thenReturn(10l);
    when(mockedSystemTelemetryService.getProcessor()).thenReturn(mockedCentralProcessor);
    sut.setService(mockedSystemTelemetryService);
  }

  @Test
  void testIfUsesService() {
    sut.getCPUInfo();
    verify(mockedSystemTelemetryService).getProcessor();
  }


  @Test
  void testIfReturnsCorrectValue() {
    ArrayList<CPUCoreDTO> cores = new ArrayList<CPUCoreDTO>();
    cores.add(new CPUCoreDTO(10, 0, 0));
    cores.add(new CPUCoreDTO(10, 0, 1));
    cores.add(new CPUCoreDTO(10, 1, 2));
    cores.add(new CPUCoreDTO(10, 1, 3));

    CPUInfoDTO expected = new CPUInfoDTO(4, 10, cores);
    CPUInfoDTO result = sut.getCPUInfo();
    assertEquals(expected, result);
  }
}
