/**
 * 
 */
package com.example.cloud.ec2.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud.ec2.beans.User;

/**
 * @author Sri
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LogManager.getLogger(UserController.class);

	@GetMapping("/all")
	public List<User> getUsers() {
		User user = new User();
		user.setUserId("1234");
		user.setName("Name");
		user.setSecretQuestion("Sec Question");
		user.setSecretAnswer("sec Answer");
		List<User> users = new ArrayList<User>();
		users.add(user);
		logger.info("UserController.getUsers");
		return users;
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		User user = new User();
		user.setUserId("userId");
		user.setName("Name");
		user.setSecretQuestion("Sec Question");
		user.setSecretAnswer("sec Answer");
		logger.info("UserController.getUser");
		return user;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody User user) {
		logger.info("UserController.createUser");
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser() {
		logger.info("UserController.delete");
	}
	
	@PutMapping("/{userId}")
	public void updateUser() {
		logger.info("UserController.update");
	}
	
}
