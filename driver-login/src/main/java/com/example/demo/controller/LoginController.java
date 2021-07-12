package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.loginbl.LoginBl;
import com.example.demo.model.UserRequest;

@CrossOrigin(origins = {"*"})
@RestController
public class LoginController {

    @Autowired
    private LoginBl loginBl;

   
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserRequest userRequest) throws Exception{
    	try {
        	
    		 return ResponseEntity.ok(loginBl.validateUser(userRequest));
    	}
    	catch (BadCredentialsException |  UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad Credential");
			
		} 

}
}