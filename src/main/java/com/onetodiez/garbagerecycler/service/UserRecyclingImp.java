package com.onetodiez.garbagerecycler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetodiez.garbagerecycler.model.User;
import com.onetodiez.garbagerecycler.model.UserRecycling;
import com.onetodiez.garbagerecycler.repository.UserRecyclingRepository;
import com.onetodiez.garbagerecycler.repository.UserRepository;

/**
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 *
 */

@Service
public class UserRecyclingImp implements UserRecyclingService{
	@Autowired
	UserRecyclingRepository urr;
	@Autowired
	UserRepository ur;

	@Override
	public UserRecycling addRecyclingToUser(UserRecycling userRecycling) {
		return urr.save(userRecycling); //save receives an entity. We save a UserRecycling
	}

	@Override
	public List<UserRecycling> getAllRecyclingFromUser(User user) {
		return urr.findByUser(user);
	}
}
