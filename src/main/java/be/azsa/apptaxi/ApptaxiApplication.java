package be.azsa.apptaxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ApptaxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptaxiApplication.class, args);
	}

}
