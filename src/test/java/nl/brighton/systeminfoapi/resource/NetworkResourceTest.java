package nl.brighton.systeminfoapi.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import nl.brighton.systeminfoapi.dto.NetworkInfoCollection;
import nl.brighton.systeminfoapi.service.NetworkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class NetworkResourceTest {

  private NetworkService mockedService;
  private NetworkResource sut;

  @BeforeEach
  void setUp() {
    sut = new NetworkResource();
    mockedService = mock(NetworkService.class);
    when(mockedService.getNetworkInfo()).thenReturn(new NetworkInfoCollection(null));
    sut.setService(mockedService);
  }

  @Test
  void getNetworkInfoReturnsStatusOK() {
    HttpStatus expected = HttpStatus.OK;
    HttpStatus result = sut.getNetworkInfo().getStatusCode();
    assertEquals(expected, result);
  }

  @Test
  void getNetworkInfoReturnsObjectOfTypeCPUInfoDTO() {
    NetworkInfoCollection expected = new NetworkInfoCollection(null);
    NetworkInfoCollection result = sut.getNetworkInfo().getBody();
    assertEquals(expected, result);
  }

  @Test
  void getNetworkInfoUsesService() {
    sut.getNetworkInfo();
    verify(mockedService).getNetworkInfo();
  }
}