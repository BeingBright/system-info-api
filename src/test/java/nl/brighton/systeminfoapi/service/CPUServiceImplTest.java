package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("unit-test")
class CPUServiceImplTest {

  private CPUServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new CPUServiceImpl();
  }
}