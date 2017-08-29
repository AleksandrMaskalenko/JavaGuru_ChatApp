package lv.javaguru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication
public class WebchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebchatApplication.class, args);
	}
}
