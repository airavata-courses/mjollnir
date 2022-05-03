package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;
import com.example.demo.repo.SignInRepo;

@Service
public class SignInService {
	
	@Autowired
	private SignInRepo repo;

	public SignInService() {
		super();
		
	}
	public void saveUser(UserEntity user) {
		try {
			repo.save(user);
		}
		catch(Exception e){
			System.out.println(e.toString());
	}
	}
	public void deleteUser(UserEntity user) {
		try {
			repo.delete(user);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public boolean auth(UserEntity user) {
		try {
			UserEntity result=repo.findByuserName(user.getUserName());
			if (result==null || result.getPassword()!=user.getPassword())
			{
				return false;
			}
			else {return true;}
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

}
