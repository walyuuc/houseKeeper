package com.chy.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.common.Page;
import com.chy.dao.UserDao;
import com.chy.entity.User;
import com.chy.manager.UserMng;
import com.chy.security.PwdEncoder;

@Service
public class UserMngImpl implements UserMng {

	public User getById(Long id) {
		User user = dao.getById(id);
		return user;
	}

	public List<User> getList() {
		return dao.getList();
	}
	
	public boolean register(User user){
		User hasUser=dao.getByUsername(user.getUsername());
		if(hasUser==null){
			//md5加密
			user.setPassword(pwdEncoder.encodePassword(user.getPassword()));
			dao.save(user);
			return true;
		}
		return false;
	}
	
	public User getByUsername(String username){
		return dao.getByUsername(username);
	}
	
	public User login(User user){
		user.setPassword(pwdEncoder.encodePassword(user.getPassword()));
		User hasUser=dao.getByUsernameAndPassword(user);
		return hasUser;
	}
	
	@Transactional
	public User update(User user){
		return dao.update(user);
	}
	
	public Page getFreeEmployer(Page page){
		page=dao.getFreeEmployer(page);
		return page;
	}
	
	@Autowired
	private UserDao dao;
	@Autowired
	private PwdEncoder pwdEncoder;
}
