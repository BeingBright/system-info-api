package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

@Tag("unit-test")
class MemoryServiceImplTest {

  private MemoryServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new MemoryServiceImpl();
  }
}