package com.onetodiez.garbagerecycler.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.onetodiez.garbagerecycler.model.User;
import com.onetodiez.garbagerecycler.model.UserRecycling;

import java.util.List;

/**
 * 
 * @author: Oneto, Fernando
 * @author: Diez, Lautaro
 *
 */

@RepositoryRestResource(exported = false)
public interface UserRecyclingRepository extends PagingAndSortingRepository<UserRecycling, Long>{
	
	List<UserRecycling> findByUser(User user); // this is automatic and returns a list of UserRecycling that matches with the given user
	
}
