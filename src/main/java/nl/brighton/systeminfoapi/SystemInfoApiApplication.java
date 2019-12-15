package nl.brighton.systeminfoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SystemInfoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemInfoApiApplication.class, args);
    }

}
