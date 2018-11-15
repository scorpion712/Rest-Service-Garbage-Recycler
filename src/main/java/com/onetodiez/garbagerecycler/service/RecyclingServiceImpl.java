package com.onetodiez.garbagerecycler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetodiez.garbagerecycler.model.Recycling;
import com.onetodiez.garbagerecycler.model.User;
import com.onetodiez.garbagerecycler.model.UserRecycling;
import com.onetodiez.garbagerecycler.repository.UserRecyclingRepository;

@Service
public class RecyclingServiceImpl implements RecyclingService {

	@Autowired
	UserRecyclingRepository urr;
	
	@Override
	public Recycling getAllRecycling(User user) {
		List<UserRecycling> list = urr.findByUser(user);
		return new Recycling(list);
	}
}
