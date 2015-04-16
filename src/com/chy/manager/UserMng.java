package com.chy.manager;

import java.util.List;

import com.chy.entity.User;

public interface UserMng {

	public User getById(Integer id);
	
	public List<User> getList();
}
