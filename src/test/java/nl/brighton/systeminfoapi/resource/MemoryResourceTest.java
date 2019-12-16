package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.MemoryInfoDTO;
import nl.brighton.systeminfoapi.service.MemoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class MemoryResourceTest {

    private MemoryService mockedService;
    private MemoryResource sut;

    @BeforeEach
    void setUp() {
        sut = new MemoryResource();
        mockedService = Mockito.mock(MemoryService.class);
        Mockito.when(mockedService.getMemoryInfo()).thenReturn(new MemoryInfoDTO(0, 0, 0, null));
        sut.setService(mockedService);
    }

    @Test
    void getMemoryInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getMemoryInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getMemoryInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new MemoryInfoDTO(0, 0, 0, null);
        var result = sut.getMemoryInfo();
        Assertions.assertEquals(expected, result.getBody());
    }

    @Test
    void getMemoryInfoUsesService() {
        sut.getMemoryInfo();
        Mockito.verify(mockedService).getMemoryInfo();
    }
}