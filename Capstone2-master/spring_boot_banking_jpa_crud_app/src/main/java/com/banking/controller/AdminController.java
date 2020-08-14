package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.banking.model.Requests;
import com.banking.model.User;
import com.banking.servcie.RegisterService;
import com.banking.servcie.RequestsService;



public class AdminController {
	
	@Autowired
	private RegisterService service;
	
	@Autowired
	private RequestsService requestsService;
	
	
	@GetMapping("/admin/getallusers")
	public ResponseEntity <List<User>> getAllUsers() {
		
//		return service.getAllUsers();
		
		 return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
	}

	@PutMapping("/admin/{uId}")
	public ResponseEntity <String> enableUser(@PathVariable int uId) {
		
		service.enableUser(uId);
		 return new ResponseEntity<>("done", HttpStatus.OK);
		
				
	}
	
	@PutMapping("/admin/disable/{uId}")
	public ResponseEntity <String> diableUser(@PathVariable int uId) {
		
		service.disableUser(uId);
		 return new ResponseEntity<>("done", HttpStatus.OK);
				
	}
	
	@DeleteMapping("/admin/delete/{uId}")
	public ResponseEntity <String> deleteUserById(@PathVariable("uId")int uId) {

		service.deleteUserById(uId);
		
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}
	
	@PutMapping("/admin/request/{requestId}")
	public ResponseEntity <String> acceptRequests(@PathVariable int requestId) {
		
		requestsService.acceptRequests(requestId);
		
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}

	@GetMapping("/admin/requests")
	public ResponseEntity <List<Requests>> findAllRequests() {
		List<Requests> requests= requestsService.findAllRequests();
		
		return new ResponseEntity<> ( requests, HttpStatus.OK);
	}

	@DeleteMapping("/admin/delete/{requestId}")
	public ResponseEntity <String> deleteRequests(int requestId) {
		
		requestsService.deleteRequests(requestId);
		 return new ResponseEntity<>("done", HttpStatus.OK);
	}

}
