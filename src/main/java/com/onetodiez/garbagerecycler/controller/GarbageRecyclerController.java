package com.onetodiez.garbagerecycler.controller;

/**
* @author: Oneto, Fernando
* @author: Diez, Lautaro
*/
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onetodiez.garbagerecycler.exceptions.IncorrectJsonFieldsException;
import com.onetodiez.garbagerecycler.exceptions.UserAlreadyExistsException;
import com.onetodiez.garbagerecycler.exceptions.UserNotFoundException;
import com.onetodiez.garbagerecycler.model.Recycling;
import com.onetodiez.garbagerecycler.model.User;
import com.onetodiez.garbagerecycler.model.UserRecycling;
import com.onetodiez.garbagerecycler.service.RecyclingService;
import com.onetodiez.garbagerecycler.service.UserRecyclingService;
import com.onetodiez.garbagerecycler.service.UserService;

@RestController
public class GarbageRecyclerController {

	@Autowired
	UserService us;

	@Autowired
	UserRecyclingService urs;
	
	@Autowired
	RecyclingService rs;

	// Post a new User (register user)
	@PostMapping(path = "/api/users")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User newUser = us.findByUsername(user.getUsername()); // get the user to check if its exists
		try { 
			newUser = us.register(user);	// try to register the new user
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newUser.getId())
					.toUri();	// setting the new user id
			return ResponseEntity.created(location).body(newUser); // send the response
		} catch (Exception e) {
			if (newUser == null) { // if the user given does not exists 
				throw new IncorrectJsonFieldsException(); // there are errors on fields
			} else {
				throw new UserAlreadyExistsException();	// there is a user registered with the same username
			}
		}
	}

	// Post a UserRecycling
	@PostMapping(path = "/api/users_recycling")
	public ResponseEntity<UserRecycling> addUserRecycling(@RequestBody UserRecycling userRecycling) {
		User user = us.findByUsername(userRecycling.getUser().getUsername()); // find a user by its username
		try {
			userRecycling.setUser(user); // set the user correspondent to the userRecycling
			UserRecycling newUserRecycling = urs.addRecyclingToUser(userRecycling);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newUserRecycling.getId())
					.toUri();	// setting the new User Recycling id
			
			return ResponseEntity.created(location).body(newUserRecycling);
		} catch (Exception e) {
			if (user == null) {
				throw new UserNotFoundException();	// if the given username does not exists
			} else {
				throw new IncorrectJsonFieldsException();	// there are errors on fields
			}
		}
	}

	// Get a UserRecycling list
	@GetMapping(path = "/api/users_recycling/{username}/")
	public ResponseEntity<List<UserRecycling>> getUserRecycling(@PathVariable(value = "username") String username) {
		User user = us.findByUsername(username); // get a user by its username
		List<UserRecycling> list = urs.getAllRecyclingFromUser(user);	// get all the user's recycling list
		if (list.size() == 0) {
			throw new UserNotFoundException();
		}
		return ResponseEntity.ok(list);
	}

	// Get a user's recycling
	@GetMapping(path = "/api/recycling/{username}/")
	public ResponseEntity<Recycling> getAllRecycling(@PathVariable(value = "username") String username) {
		User user = us.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException();
		}
		Recycling recycling = rs.getAllRecycling(user); 
		return new ResponseEntity<>(recycling, HttpStatus.OK);
		
	}

	/*
	 * 
	 * @GetMapping(path = "/api/users") public ResponseEntity<List<User>> getUsers(
	 * ){ List<User> list = us.getAllUsers();
	 * 
	 * return ResponseEntity.ok(list); }
	 */

	// Get a user data by its username
	@GetMapping(path = "/api/users/{username}/")
	public ResponseEntity<User> getUser(@PathVariable(value = "username") String username) {
		User user = us.findByUsername(username);

		return ResponseEntity.ok(user);
	}

}
