package com.study.customerService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.customerService.bean.User;

@Repository("UserDao")
public interface UserDao {

	public List<User> findByName(String name);
	
	public List<User> findAll();
	
}
