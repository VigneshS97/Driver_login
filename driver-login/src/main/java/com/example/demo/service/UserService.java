package com.example.demo.service;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CabInfo;
import com.example.demo.model.DriverInfo;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.DriverInfoRepo;
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private DriverInfoRepo driverInfoRepo;
	
	@Autowired
	private CabInfoRepo  cabInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	CabInfo cabInfo=this.cabInfoRepo.findByCabNumber(username);
    	if(cabInfo ==  null) {
			throw new UsernameNotFoundException("Bad Credentials");
		}
    	
    	long driverId=cabInfo.getDriverId();
    	
    	DriverInfo driverInfo=this.driverInfoRepo.findByDriverId(driverId);
    	
    	
		

        return new User(cabInfo.getCabNumber(),driverInfo.getPassword(),true,true,true,true,null);
    }
}