package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.MessageDao;
import com.icloud.entity.Message;
import com.icloud.service.MessageService;

public class MessageServiceImpl implements MessageService{
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public Message getMessage(int id) {
		return messageDao.getMessage(id);
	}
	
	@Override
	public Message getMessageList(int offer) {
		return messageDao.getMessageList(offer);
	}
	
	@Override
	public int getCount() {
		return messageDao.getCount();
	}

	@Override
	public List<Message> getAllMessage() {
		return messageDao.getAllMessage();
	}

	@Override
	public int addMessage(Message message) {
		return messageDao.addMessage(message);
	}

	@Override
	public boolean delMessage(int id) {
		return messageDao.delMessage(id);
	}

	@Override
	public boolean updateMessage(Message message) {
		return messageDao.updateMessage(message);
	}

	@Override
	public Message selectNowMessage() {
		// TODO Auto-generated method stub
		return messageDao.selectNowMessage();
	}

}
