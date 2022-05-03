package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;

@Repository
public interface SignInRepo extends CrudRepository<UserEntity,String> {
	UserEntity findByuserName(String userName);

}
