package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.DiskInfoCollection;
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
        Mockito.when(mockedService.getDiskInfo()).thenReturn(new DiskInfoCollection(null));
        sut.setService(mockedService);
    }

    @Test
    void getDiskInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getDiskInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getDiskInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new DiskInfoCollection(null);
        var result = sut.getDiskInfo();
        Assertions.assertEquals(expected, result.getBody());
    }

    @Test
    void getDiskInfoUsesService() {
        sut.getDiskInfo();
        Mockito.verify(mockedService).getDiskInfo();
    }
}