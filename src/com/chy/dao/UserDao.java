package com.chy.dao;

import java.util.List;

import com.chy.common.Page;
import com.chy.entity.User;

public interface UserDao {

	public User getById(Long id);
	
	public List<User> getList();
	
	public Long save(User user);
	
	public User getByUsername(String username);
	
	public User getByUsernameAndPassword(User user);
	
	public User update(User user);
	
	public void delete(Long userId);
	
	public List<User> getFreeEmployer(Page page);
	
	public int getFreeEmployerCount();
}
