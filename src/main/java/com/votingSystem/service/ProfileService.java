package com.votingSystem.service;

import com.votingSystem.entity.Profile;

public interface ProfileService {

	public Profile setProfile(Profile profile);
	
	public Profile getById(int id);
	
	public boolean existById(int id);
}