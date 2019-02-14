package com.icloud.service.impl;

import java.util.List;

import com.icloud.dao.ManagerDao;
import com.icloud.entity.Manager;
import com.icloud.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	private ManagerDao managerDao;

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public Manager getManager(int id) {
		return managerDao.getManager(id);
	}

	@Override
	public List<Manager> getAllManager() {
		return managerDao.getAllManager();
	}

	@Override
	public int addManager(Manager manager) {
		return managerDao.addManager(manager);
	}

	@Override
	public boolean delManager(int id) {
		return managerDao.delManager(id);
	}

	@Override
	public boolean updateManager(Manager manager) {
		return managerDao.updateManager(manager);
	}

	@Override
	public Manager getManagerByName(String name, String password) {
		return managerDao.getManagerByName(name,password);
	}

	
}
