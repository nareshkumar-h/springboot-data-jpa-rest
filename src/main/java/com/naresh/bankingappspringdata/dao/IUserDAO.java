package com.naresh.bankingappspringdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naresh.bankingappspringdata.model.User;

public interface IUserDAO extends JpaRepository<User,Integer>{

	User save(User user);

	@Query("select u from User u")
	List<User> list();
	
	@Query("select u from User u where u.id = :userId")
	User findOne(@Param("userId") Integer id);

	@Query("delete from User where id = :userId")
	void delete(@Param("userId") Integer id);

}