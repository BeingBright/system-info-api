package nl.brighton.systeminfoapi.service;

import org.junit.jupiter.api.BeforeEach;

class MemoryServiceImplTest {

  private MemoryServiceImpl sut;

  @BeforeEach
  void setUp() {
    sut = new MemoryServiceImpl();
  }
}