package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("unit-test")
class NetworkServiceImplTest {

  private NetworkServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new NetworkServiceImpl();
  }
}