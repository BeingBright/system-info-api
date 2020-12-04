package nl.brighton.systeminfoapi.service.exception;

public class DiskNotFoundException extends RuntimeException {

  public DiskNotFoundException(String disk) {
    super(String.format("Disk: '%s' not found", disk));
  }
}
