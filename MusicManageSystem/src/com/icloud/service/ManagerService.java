package com.icloud.service;

import java.util.List;

import com.icloud.entity.Manager;

public interface ManagerService {
	
	public Manager getManager(int id);

	public List<Manager> getAllManager();

	public int addManager(Manager manager);

	public boolean delManager(int id);

	public boolean updateManager(Manager manager);
	
	public Manager getManagerByName(String name, String password);
}
