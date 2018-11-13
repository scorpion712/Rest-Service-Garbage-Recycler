package com.onetodiez.garbagerecycler.controller;
/**
* @author: Oneto, Fernando
* @author: Diez, Lautaro
*/
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	//@Autowired
	//RecyclingService rs;

	@PostMapping(path = "/api/users")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User newUser = us.register(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(newUser);
	}

/*		Es útil ?? El servicio no habla de que lo provee
 * 
	@GetMapping(path = "/api/users")
	public ResponseEntity<List<User>> getUsers( ){
		List<User> list = us.getAllUsers();

		return ResponseEntity.ok(list);
	}
*/

	@GetMapping(path = "/api/users/{username}/")
	public ResponseEntity<User> getUser(@PathVariable(value = "username") String username){
		User user = us.findByUsername(username);

		return ResponseEntity.ok(user);
	}



	//Post a UserRecycling
	@PostMapping(path = "/api/users_recycling")
	public ResponseEntity<UserRecycling> addUserRecycling(@RequestBody UserRecycling userRecycling, @RequestBody String username) {
		User user = us.findByUsername(username);
		UserRecycling newUserRecycling = urs.addRecyclingToUser(username, userRecycling);
		//newUserRecycling.setUserId(user.getId()); // like set the "FK"
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUserRecycling.getId())
				.toUri();
		return ResponseEntity.created(location).body(newUserRecycling);
	}

	// Get a UserRecycling list
	@GetMapping(path = "/api/users_recycling/{username}/")
	public ResponseEntity<List<UserRecycling>> getUserRecycling(@PathVariable(value = "username") String username) {
		List<UserRecycling> list = urs.getAllRecyclingFromUser(username);

		return ResponseEntity.ok(list);
	}
/*
	// Get a user's recycling
	@GetMapping(path = "/api/recycling/{username}/")
	public ResponseEntity<Recycling> getRecycling(@PathVariable(value = "username") String username) {
		Recycling recycling = rs.findByUsername(username);

		return ResponseEntity.ok(recycling);
	}
 */

}
