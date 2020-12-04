package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("unit-test")
class DiskServiceImplTest {

  private DiskServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new DiskServiceImpl();
  }
}