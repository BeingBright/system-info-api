package nl.brighton.systeminfoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableWebMvc
public class SystemInfoApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemInfoApiApplication.class, args);
  }
}
