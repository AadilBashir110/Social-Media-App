package com.adil.service;

import java.util.List;

import com.adil.exceptions.ReelsException;
import com.adil.exceptions.UserException;
import com.adil.models.Reels;
import com.adil.models.User;

public interface ReelsService {

	public Reels createReel(Reels reel, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userId) throws ReelsException, UserException;
}
