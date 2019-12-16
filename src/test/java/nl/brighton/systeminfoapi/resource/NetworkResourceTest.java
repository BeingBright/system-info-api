package nl.brighton.systeminfoapi.resource;

import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.service.NetworkService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

class NetworkResourceTest {

    private NetworkService mockedService;
    private NetworkResource sut;

    @BeforeEach
    void setUp() {
        sut = new NetworkResource();
        mockedService = Mockito.mock(NetworkService.class);
        Mockito.when(mockedService.getNetworkInfo()).thenReturn(new NetworkInfoCollection(null));
        sut.setService(mockedService);
    }

    @Test
    void getNetworkInfoReturnsStatusOK() {
        var expected = HttpStatus.OK;
        var result = sut.getNetworkInfo();
        Assertions.assertEquals(expected, result.getStatusCode());
    }

    @Test
    void getNetworkInfoReturnsObjectOfTypeCPUInfoDTO() {
        var expected = new NetworkInfoCollection(null);
        var result = sut.getNetworkInfo();
        Assertions.assertEquals(expected, result.getBody());
    }

    @Test
    void getNetworkInfoUsesService() {
        sut.getNetworkInfo();
        Mockito.verify(mockedService).getNetworkInfo();
    }
}