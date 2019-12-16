package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.ProcessInfoCollection;
import nl.brighton.systeminfoapi.service.ProcessService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class ProcessResourceTest {

    private ProcessService mockedService;
    private ProcessResource sut;

    @BeforeEach
    void setUp() {
        sut = new ProcessResource();
        mockedService = Mockito.mock(ProcessService.class);
        Mockito.when(mockedService.getProcess()).thenReturn(new ProcessInfoCollection(null));
        sut.setService(mockedService);
    }

    @Test
    void getProcessInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getProcessInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getProcessInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new ProcessInfoCollection(null);
        var result = sut.getProcessInfo();
        Assertions.assertEquals(expected, result.getBody());
    }

    @Test
    void getProcessInfoUsesService() {
        sut.getProcessInfo();
        Mockito.verify(mockedService).getProcess();
    }
}