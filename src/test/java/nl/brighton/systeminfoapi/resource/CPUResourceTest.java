package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.CPU;
import nl.brighton.systeminfoapi.service.CPUService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class CPUResourceTest {

    private CPUService mockedService;
    private CPUResource sut;

    @BeforeEach
    void setUp() {
        sut = new CPUResource();
        mockedService = Mockito.mock(CPUService.class);
        Mockito.when(mockedService.getCPUInfo()).thenReturn(null);
        sut.setService(mockedService);
    }

    @Test
    void getCPUInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getCPUInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getCPUInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new CPU();
        var result = sut.getCPUInfo();
        Assertions.assertEquals(expected, result.getBody());
    }

    @Test
    void getCPUInfoUsesService() {
        sut.getCPUInfo();
        Mockito.verify(mockedService).getCPUInfo();
    }
}