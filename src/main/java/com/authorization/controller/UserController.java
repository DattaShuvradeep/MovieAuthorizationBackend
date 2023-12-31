package com.authorization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorization.model.User;
import com.authorization.service.UserService;

@RestController
@RequestMapping("/api/v1.0/moviebooking")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers()
	{
		
		List<User> userlist = userService.getAllUsers();
		
		if(userlist!=null)
		{
			return new ResponseEntity<>(userlist, HttpStatus.OK);
		}
		return new ResponseEntity<>("userlist is empty", HttpStatus.NO_CONTENT);
	}

}
