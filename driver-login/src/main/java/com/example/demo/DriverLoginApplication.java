package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.CabInfo;
import com.example.demo.model.DriverInfo;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.DriverInfoRepo;

@SpringBootApplication
public class DriverLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverLoginApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			private DriverInfoRepo driverRepo;
			
			@Autowired
			private CabInfoRepo cabInfoRepo;
			
			@Override
			public void run(String... args) throws Exception {
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
				Date date = df.parse("12-10-2025");
				
				this.driverRepo.save(new DriverInfo(101, "sugu", "1234567890", 19060, "LC7D7890", date));
				
				
				this.cabInfoRepo.save(new CabInfo("TN50D1278", 101, "swift", 10, "1526387", date, null, 0, null, null, null, null));
			}
		};
	}
	
	
	}


