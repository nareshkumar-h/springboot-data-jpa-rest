package com.naresh.bankingappspringdata.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.naresh.bankingappspringdata.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testInsertUser() {
		User user = new User();
		user.setName("naresh");
		user.setEmail("naresh@gmail.com");
		user.setPassword("pass123");
		//userDAO.save(user);
	}
	
	@Test
	public void testListUser() {
		List<User> list = userDAO.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
