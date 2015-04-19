package com.chy.manager.impl;

import java.util.List;

import net.sf.ehcache.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.dao.UserDao;
import com.chy.entity.User;
import com.chy.manager.UserMng;

@Service("userService")
public class UserMngImpl implements UserMng {

	public User getById(Integer id) {
		User user = dao.getById(id);
		return user;
	}

	public List<User> getList() {
		return dao.getList();
	}
	
	public boolean register(User user){
		User hasUser=dao.getByUsername(user.getUsername());
		if(hasUser==null){
			Long res=dao.save(user);
			return res==0?false:true;
		}
		return false;
	}
	
	public User getByUsername(String username){
		return dao.getByUsername(username);
	}
	
	public boolean login(User user){
		User hasUser=dao.getByUsernameAndPassword(user);
		return hasUser==null?false:true;
	}
	
	@Autowired
	private UserDao dao;
	
}
