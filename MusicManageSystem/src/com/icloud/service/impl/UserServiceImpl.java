package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.UserDao;
import com.icloud.entity.User;
import com.icloud.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean delUser(int id) {
		return userDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User getUserByName(String name,String passward) {
		return userDao.getUserByName(name,passward);
	}

	@Override
	public User findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(username);
	}

}
