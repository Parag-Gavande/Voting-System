package com.votingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingSystem.entity.Admin;
import com.votingSystem.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public void saveAdmin(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public List<Admin> adminList() {
		return adminRepo.findAll();
	}

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		return adminRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public void deleteById(String voterId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long voterId) {
		// TODO Auto-generated method stub
		
	}
}
