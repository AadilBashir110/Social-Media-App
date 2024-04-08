package com.adil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.adil.exceptions.StoryException;
import com.adil.exceptions.UserException;
import com.adil.models.Story;
import com.adil.models.User;
import com.adil.service.StoryService;
import com.adil.service.UserService;

@RestController
public class StoryController {

	@Autowired
	private UserService userService;
	@Autowired
	private StoryService storyService;
	
	@PostMapping("/api/story")
	public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt) {
	
		User reqUser = userService.findUserByJwt(jwt);
		Story createdStory = storyService.createStory(story, reqUser);
		
		return createdStory;
	}
	
	@GetMapping("/api/story/user/{userId}")
	public List<Story> findUsersStory(@PathVariable Integer userId, @RequestHeader("Authorization") String jwt) throws StoryException, UserException {
	
		User reqUser = userService.findUserByJwt(jwt);
		List<Story> stories = storyService.findStoryByUserId(userId);
		
		return stories;
	}
	
}
