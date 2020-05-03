package batchfour.teamtwo.renttrailservice;

import batchfour.teamtwo.renttrailservice.configs.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class RentTrailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentTrailServiceApplication.class, args);
	}

}
