package com.example.demo.dl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.CabInfo;
import com.example.demo.repo.CabInfoRepo;

@Component
public class LoginDl {

	@Autowired
	private CabInfoRepo cabInfoRepo;
	
	public CabInfo findByCabNumber(String cabNumber) {
		return this.cabInfoRepo.findByCabNumber(cabNumber);
	}
	
}
