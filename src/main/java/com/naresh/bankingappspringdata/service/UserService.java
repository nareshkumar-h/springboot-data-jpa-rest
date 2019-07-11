package com.naresh.bankingappspringdata.service;

import java.util.List;

import com.naresh.bankingappspringdata.model.User;

public interface UserService {

	void registerUser(User user);

	List<User> list();
	
	User findOne(Integer id);

	void delete(Integer id);

	void update(User user);

}