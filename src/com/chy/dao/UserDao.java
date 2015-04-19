package com.chy.dao;

import java.util.List;

import com.chy.entity.User;

public interface UserDao {

	public User getById(Integer id);
	
	public List<User> getList();
	
	public Long save(User user);
	
	public User getByUsername(String username);
	
	public User getByUsernameAndPassword(User user);
}
