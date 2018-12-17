package com.onetodiez.garbagerecycler.service;

import com.onetodiez.garbagerecycler.model.Recycling;

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

import com.onetodiez.garbagerecycler.model.User;

public interface RecyclingService {
	Recycling getAllRecycling(User user);
}
