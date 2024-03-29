package com.naresh.bankingappspringdata.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.bankingappspringdata.dao.UserDAO;
import com.naresh.bankingappspringdata.exception.ServiceException;
import com.naresh.bankingappspringdata.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;// = new UserDAO();

	@Transactional
	public void registerUser(User user) {
		userDAO.save(user);
	}

	@Transactional
	public List<User> list() {
		return userDAO.list();
	}

	@Transactional
	public User findOne(Integer id) {
		User user = null;

		user = userDAO.findOne(id);
		if (user == null) {
			throw new ServiceException("User id not found");
		}
		return user;
	}

	@Transactional
	public void delete(Integer id) {
		userDAO.delete(id);
	}

	@Override
	public void update(User user) {
		userDAO.save(user);
	}

	@Override
	public User login(User user) {
		User userResult = userDAO.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return userResult;
	}

}
