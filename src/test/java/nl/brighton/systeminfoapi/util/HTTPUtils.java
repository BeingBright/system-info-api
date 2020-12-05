package nl.brighton.systeminfoapi.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HTTPUtils {

  public static ResponseEntity<?> sendGET(String url, Class<?> resultClass) {
    RestTemplate template = new RestTemplate();
    return template.getForEntity(url, resultClass);
  }

  public static ResponseEntity<?> post(String url, Object objectToSend, Class<?> resultClass) {
    RestTemplate template = new RestTemplate();
    return template.postForEntity(url, objectToSend, resultClass);
  }

  public static String sendGET(String url, String parameter) {
    return "";
  }
}
