package com.onetodiez.garbagerecycler.service;
/**
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 *
 */

import java.util.List;

import com.onetodiez.garbagerecycler.model.User;
import com.onetodiez.garbagerecycler.model.UserRecycling;

public interface UserRecyclingService {
	
	// Add recycling to user
	UserRecycling addRecyclingToUser(UserRecycling userRecycling);
	
	// Get user recycling from a given user
	List<UserRecycling> getAllRecyclingFromUser(User user);
	
}
