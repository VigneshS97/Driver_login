package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminContacts;
import com.example.demo.model.CabInfo;
import com.example.demo.model.TripCabInfo;
import com.example.demo.repo.AdminContactsRepository;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.DriverNotificationRepository;

@RestController
public class DriverNotificationController {

	@Autowired
	private DriverNotificationRepository repofordrivernotification;
	
	@Autowired
	private AdminContactsRepository reposs;
	
	@Autowired
	private CabInfoRepo cabInfoRepo;
	
	//this is kishore code
	 //FOR DRIVER'S NOTIFICATION
	@GetMapping(path="/notification")
	public List<TripCabInfo> getNotification() {
		 return this.repofordrivernotification.findAll();
	}

	@GetMapping(path="/notification/{cabNumber}")
	public TripCabInfo getNotificationByCabNumber(@PathVariable String cabNumber) {
		TripCabInfo tripObj = this.repofordrivernotification.getTripAssignedDetailsByCabNumber(cabNumber);
		return tripObj;
	}



	//FOR DRIVER PROFILES

	@GetMapping(path="/driverProfile")
	public List<CabInfo> getDriverProfile() {
		 return this.cabInfoRepo.findAll();
	}


	@GetMapping(path="/driverProfile/{cabNumber}")
	public CabInfo getProfileByCabNumber(@PathVariable String cabNumber) {
		 return this.cabInfoRepo.findByCabNumber(cabNumber);
	}

	//FOR ADMIN CONTACT DETAILS

	@GetMapping(path="/adminContactDetails")
	public List<AdminContacts> getAdminContacts(){
		return this.reposs.findAll();
		
	}

	
}
