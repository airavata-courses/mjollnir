package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface SignInRepo extends CrudRepository<User,String> {
	User findByuserName(String userName);

}
