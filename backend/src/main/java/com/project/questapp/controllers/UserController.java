package com.project.questapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserRepository userRepository;
	public UserController(UserRepository userRepository ) {
		this.userRepository=userRepository;
		
	}
@GetMapping
//getirmek için
public List<User> getAllUsers(){
	return userRepository.findAll();
}
@PostMapping
//biri yeni bir user create etmek istediğinde kullanılır 
	public User createUser(@RequestBody User newUser) {
	return userRepository.save(newUser);
	
}
}
