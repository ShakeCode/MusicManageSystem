package com.icloud.service;

import java.util.List;

import com.icloud.entity.Lyc;

public interface LycService {
	
	public Lyc getLyc(int id);

	public List<Lyc> getAllLyc();

	public int addLyc(Lyc lyc);

	public boolean delLyc(int id);

	public boolean updateLyc(Lyc lyc);
}
