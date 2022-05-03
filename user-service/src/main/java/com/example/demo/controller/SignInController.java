package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEntity;
import com.example.demo.service.SignInService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="/usercontroller")
public class SignInController {
	
	@Autowired
	SignInService inService;
	
	public SignInController(SignInService inService) {
		super();
		this.inService = inService;
	}
	
	@GetMapping(path = "/root")
	public String Hello() {
		System.out.println("Hello world");
		return "Hello world";
		//this.inService.saveUser(user);
	}

	@PostMapping(path = "/root/save")
	public ResponseEntity saveUser(@RequestBody UserEntity user) {
		
		
		this.inService.saveUser(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping(path = "/root/delete")
	public ResponseEntity deleteUser(@RequestBody UserEntity user) {
		
		
		this.inService.deleteUser(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PostMapping(path = "/root/auth")
	public ResponseEntity auth(@RequestBody UserEntity user) {
		
		
		if (this.inService.auth(user)==true) {
		return ResponseEntity.ok(HttpStatus.CREATED);}
		else {return ResponseEntity.ok(HttpStatus.UNAUTHORIZED);}
	}

}
