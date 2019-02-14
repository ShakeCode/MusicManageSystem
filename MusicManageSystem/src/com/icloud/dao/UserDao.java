package com.icloud.dao;

import java.util.List;

import com.icloud.entity.User;

public interface UserDao {

	public User getUser(int id);
	
	public User getUserByName(String name,String passward);
	
	public List<User> getAllUser();

	public int addUser(User user);

	public boolean delUser(int id);

	public boolean updateUser(User user);
	
	public User findUserByUserName(String username);
}
