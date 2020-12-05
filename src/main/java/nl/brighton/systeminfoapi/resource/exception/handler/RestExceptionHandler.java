package nl.brighton.systeminfoapi.resource.exception.handler;

import nl.brighton.systeminfoapi.service.MemoryService;
import nl.brighton.systeminfoapi.service.exception.DiskNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class RestExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(MemoryService.class);

  @ExceptionHandler({
      DiskNotFoundException.class,
      NoHandlerFoundException.class
  })
  public ResponseEntity<JSONException> notFoundHandler(Exception e, WebRequest webRequest) {
    LOGGER.warn("'{}' {}", e.getMessage(), webRequest.getDescription(false));
    return buildResponse(HttpStatus.NOT_FOUND, e);
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<JSONException> internalServerHandler(Exception e, WebRequest webRequest) {
    LOGGER.error("'{}' {}", e.getMessage(), webRequest.getDescription(false));
    return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e);
  }

  private ResponseEntity<JSONException> buildResponse(HttpStatus status, Exception e) {
    return ResponseEntity.status(status)
        .body(new JSONException(e.getMessage(), status.toString(), status.value()));
  }

  public static class JSONException {

    private final String message;
    private final String status;
    private final int statusCode;

    public JSONException(String message, String status, int statsCode) {
      this.message = message;
      this.status = status;
      this.statusCode = statsCode;
    }

    public String getMessage() {
      return message;
    }

    public String getStatus() {
      return status;
    }

    public int getStatusCode() {
      return statusCode;
    }
  }
}
