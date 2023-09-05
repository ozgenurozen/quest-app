package com.project.questapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.repos.UserRepository;
import com.project.questapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	public UserController(UserRepository userRepository ) {
		this.userService=userService;
		
	}
@GetMapping
//getirmek için
public List<User> getAllUsers(){
	return userService.getAllUSers();
}
@PostMapping
//biri yeni bir user create etmek istediğinde kullanılır 
	public User createUser(@RequestBody User newUser) {
	return userService.saveOneUser(newUser);
	
}
@GetMapping("/{userID}")
public User getOneUSer(@PathVariable Long userId) {
	
	return userService.getOneUserById(userId);
	
	
}
@PutMapping("/{userId}")
public User updateOneUser(@PathVariable long userId,@RequestBody User newUser) {
	return userService.updateOneUser(userId,newUser);
	
}
@DeleteMapping("/{userId}")
public void deleteOneUser(@PathVariable long userId) {
	userService.deleteById(userId);
}
}
