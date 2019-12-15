package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.SystemInfoDTO;
import nl.brighton.systeminfoapi.service.SystemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class SystemResourceTest {

    private SystemService mockedService;
    private SystemResource sut;


    @BeforeEach
    void setUp() {
        sut = new SystemResource();
        mockedService = Mockito.mock(SystemService.class);
        Mockito.when(mockedService.getSystemInfo()).thenReturn(new SystemInfoDTO("", "", "", "", "", ""));
        sut.setService(mockedService);
    }

    @Test
    void getSystemInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getSystemInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getSystemInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new SystemInfoDTO("", "", "", "", "", "");
        var result = sut.getSystemInfo();
        Assertions.assertEquals(expected, result.getBody());
    }
}