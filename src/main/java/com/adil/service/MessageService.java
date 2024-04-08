package com.adil.service;

import java.util.List;

import com.adil.exceptions.ChatException;
import com.adil.exceptions.MessageException;
import com.adil.models.Message;
import com.adil.models.User;

public interface MessageService {

	public Message createMessage(User user,Integer chatId,Message req) throws MessageException, ChatException;
	
	public List<Message> findChatsMessages(Integer chatId) throws MessageException, ChatException;
	
}
