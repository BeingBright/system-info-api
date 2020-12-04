package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("unit-test")
class SystemServiceImplTest {

  private SystemServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new SystemServiceImpl();
  }
}