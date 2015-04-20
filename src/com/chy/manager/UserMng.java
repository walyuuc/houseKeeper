package com.chy.manager;

import java.util.List;

import com.chy.entity.User;

public interface UserMng {

	public User getById(Long id);
	
	public List<User> getList();
	
	public boolean register(User user);
	
	public User getByUsername(String username);
	
	public User login(User user);
	
	public User update(User user);
}
