package com.onetodiez.garbagerecycler.service;

import com.onetodiez.garbagerecycler.model.User;

public interface UserService {
	User register(User user);	// register a new user

	User findByUsername (String username); // find a user by its surname

	//List<User> getAllUsers(); //delete
}
