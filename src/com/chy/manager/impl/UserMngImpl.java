package com.chy.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.dao.UserDao;
import com.chy.entity.User;
import com.chy.manager.UserMng;

@Service
@Transactional
public class UserMngImpl implements UserMng {

	@Transactional(readOnly = true)
	public User getById(Integer id) {
		User user = dao.getById(id);
		return user;
	}

	public List<User> getList() {
		return dao.getList();
	}
	
	@Autowired
	private UserDao dao;

	
}
