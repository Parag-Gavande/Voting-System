package com.votingSystem.service;

import java.util.List;

import com.votingSystem.entity.Admin;

public interface AdminService {
	
	public void saveAdmin(Admin admin);
	public List<Admin> adminList();
	public Admin findByUsernameAndPassword(String username, String password);
	public void deleteById(String voterId);
	public void deleteById(Long voterId);
}
