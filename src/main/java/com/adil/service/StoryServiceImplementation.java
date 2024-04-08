package com.adil.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.exceptions.StoryException;
import com.adil.exceptions.UserException;
import com.adil.models.Story;
import com.adil.models.User;
import com.adil.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService {

	@Autowired
	private StoryRepository storyRepository;
	@Autowired
	private UserService userService;
	@Override
	public Story createStory(Story story, User user) {
		
		Story createdStory = new Story();
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());
		return storyRepository.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws StoryException, UserException {

		User user = userService.findUserById(userId);
		
		return storyRepository.findByUserId(userId);
	}

}
