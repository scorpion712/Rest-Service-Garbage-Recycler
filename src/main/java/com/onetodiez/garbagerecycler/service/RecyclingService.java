package com.onetodiez.garbagerecycler.service;

import com.onetodiez.garbagerecycler.model.Recycling;
import com.onetodiez.garbagerecycler.model.User;

public interface RecyclingService {
	Recycling getAllRecycling(User user);
}
