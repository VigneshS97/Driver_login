package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.BookingRequest;
import com.example.demo.model.CabInfo;
import com.example.demo.model.TripCabInfo;
import com.example.demo.repo.AdminContactsRepository;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.TripCabInfoRepository;

@SpringBootApplication
public class DriverLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverLoginApplication.class, args);
	}
	
	 @Autowired
	 private BookingRepository repo; 
	 @Autowired
	 private TripCabInfoRepository triprepo;
	 @Autowired
	 private AdminContactsRepository AdminContactsReposs;
	 
	 @Autowired
	 private CabInfoRepo repos;
	 
	
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			
			@Override
			public void run(String... args) throws Exception {
				
				
				CabInfo cabInfo=new CabInfo("TN50S6677", 101, "Swift", 10, "LC12D90",null , "Jawahar", 0, null, null, null, null);
				repos.save(cabInfo);			
				
				/*
				 * AdminContacts contacts1 = new AdminContacts("+91- 123456789",
				 * "Ragahavan",true); AdminContacts contacts2 = new
				 * AdminContacts("+91-(123)8492003", "santhosh",true);
				 * AdminContactsReposs.save(contacts1); AdminContactsReposs.save(contacts2);
				 * 
				 * 
				 * BookingRequest book2=new
				  BookingRequest(10022,10722,"gokul","alphacity","shollinganallur","velachery",
				 * LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,"assigned",
				 * null,null,null,null,0); TripCabInfo tripdetails = new TripCabInfo(10001,
				 * "TN8S6677", 10, "Bayline", "Tambaram", "Shollingnallur", LocalDate.now(),
				 * LocalTime.now(), 10,2,8,LocalTime.of(10, 30), null, null, null, null, null,
				 * null, 0); triprepo.save(tripdetails); repo.save(book2);
				 * 
				 * DriverProfile profile = new DriverProfile("Jawahar","Driver","TN8S6677");
				 * DriverProfileRepos.save(profile);
				 */
				
				
				  TripCabInfo tripdetails = new
				  TripCabInfo(10003,"TN50S6677",10,"Bayline","Tambaram","Shollingnalur",
				  LocalDate.now(), LocalTime.now(),10,2,8,LocalTime.of(10,
				  35),null,"Assigned",null,null,null,null,0); triprepo.save(tripdetails);
				  
				  BookingRequest book2=new
				  BookingRequest(10024,"10723","Gokul","alphacity","shollinganallur",
				  "velachery",
				  LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,"assigned",
				  null,null,null,null,0); repo.save(book2);
				 
			
			}
		};
	}
	
	
	}


