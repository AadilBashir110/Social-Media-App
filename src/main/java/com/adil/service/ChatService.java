package com.adil.service;

import java.util.List;

import com.adil.exceptions.ChatException;
import com.adil.models.Chat;
import com.adil.models.User;

public interface ChatService {

	public Chat createChat(User reqUser,User user2);
	public Chat findChatById(Integer chatId) throws ChatException;
	public List<Chat> findUsersChat(Integer userId);
}
