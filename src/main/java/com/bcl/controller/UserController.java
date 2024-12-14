package com.bcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcl.entity.User;
import com.bcl.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<User>> getUser(){
		List<User> list= userService.getUser();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable Long id){
		User user= userService.getUserById(id);
		return user;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.addUser(user);
		return ResponseEntity.ok(savedUser);
	}
	

}
