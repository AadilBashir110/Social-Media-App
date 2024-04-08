package com.adil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.adil.exceptions.ChatException;
import com.adil.exceptions.UserException;
import com.adil.models.Chat;
import com.adil.models.User;
import com.adil.request.CreateChatRequest;
import com.adil.service.ChatService;
import com.adil.service.UserService;

@RestController
public class ChatController {

	@Autowired
	private ChatService chatService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chats")
	public Chat createChat(
			@RequestHeader("Authorization") String jwt,
			@RequestBody CreateChatRequest req) throws ChatException, UserException {
		
		User reqUser = userService.findUserByJwt(jwt);
		User user2 = userService.findUserById(req.getUserId());
		Chat chat = chatService.createChat(reqUser, user2);
		return chat;
	}

@GetMapping("/api/chats")
public List<Chat> findUsersChat(@RequestHeader("Authorization") String jwt) {
	User user = userService.findUserByJwt(jwt);
	
	List<Chat> chats = chatService.findUsersChat(user.getId());
	
	return chats;
}
}