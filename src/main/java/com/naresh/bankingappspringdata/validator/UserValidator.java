package com.naresh.bankingappspringdata.validator;

import org.springframework.stereotype.Component;

import com.naresh.bankingappspringdata.exception.ValidatorException;
import com.naresh.bankingappspringdata.model.User;

@Component
public class UserValidator {

	public void validateUser(User user) {
		if (user.getName() == null || "".equals(user.getName()) ) {
			throw new ValidatorException("Invalid Name");
		}
	}
	
}
