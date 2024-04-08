package com.adil.service;

import java.util.List;

import com.adil.exceptions.StoryException;
import com.adil.exceptions.UserException;
import com.adil.models.Story;
import com.adil.models.User;

public interface StoryService {

	public Story createStory(Story story, User user);
	public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException;
}
