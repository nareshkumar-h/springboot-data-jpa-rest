package com.naresh.bankingappspringdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.bankingappspringdata.model.User;
import com.naresh.bankingappspringdata.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping()
	public @ResponseBody void register(@RequestBody User user) {
		System.out.println("UserController->save");
		userService.registerUser(user);
	}
	

	@PutMapping("/{id}")
	public @ResponseBody void update(@PathVariable("id") Integer id,@RequestBody User user) {
		System.out.println("UserController->update" + id);
		userService.update(user);
	}

	@GetMapping()
	public List<User> list() {
		List<User> list = userService.list();
		return list;
	}

	@GetMapping("/{id}")
	public User findOne(@PathVariable("id") Integer id) {
		User user = userService.findOne(id);
		return user;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.delete(id);

	}

}
