package com.icloud.service;

import java.util.List;

import com.icloud.entity.Message;

public interface MessageService {
	
	public Message getMessage(int id);
	
	public Message getMessageList(int offer);
	
	public int getCount();

	public List<Message> getAllMessage();

	public int addMessage(Message message);

	public boolean delMessage(int id);

	public boolean updateMessage(Message message);
	
	//��ѯ����֪ͨ
	public Message selectNowMessage();
}
