package com.example.demo.loginbl;

import java.net.MalformedURLException;
import java.security.Principal;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dl.LoginDl;
import com.example.demo.model.CabInfo;
import com.example.demo.model.UserRequest;
import com.example.demo.util.JwtUtils;
@Component
public class LoginBl {
	
	@Autowired
	private UserRequest empBo;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private LoginDl loginDl;
	
	@Autowired
	private JwtUtils jwtUtil;
	
	public String validateUser(@RequestBody UserRequest driver) throws ExecutionException, InterruptedException, MalformedURLException {
		String jwt = null;
		
		CabInfo cabInfo = this.loginDl.findByCabNumber(driver.getLoginId());
		
		if(cabInfo == null) {
			throw new BadCredentialsException("User Not Found");
		}
		
		
		try {
			//decode the base64 encoded password
			

			//for db authentication spring security
										//spring security authentication
			authManager.authenticate(new UsernamePasswordAuthenticationToken(driver.getLoginId(), driver.getPassword()));
			jwt="Bearer "+jwtUtil.generateToken(driver.getLoginId());
			
		
			//this exception occurs on invalid credentials or if account is locked
		} catch (BadCredentialsException |  UsernameNotFoundException e) {
			throw e;
			
		} 
		
		
		return jwt;
	}
	
	

}
