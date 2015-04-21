package com.chy.service;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.chy.dao.UserDao;
import com.chy.entity.User;

@Component("userService")
public class UserServiceImpl implements UserService{

	public String getById(Long id) {
		User user = dao.getById(id);
		return JSONObject.fromObject(user).toString();
	}

	public void delete(Long userId){
		dao.delete(userId);
		System.out.println("delete:"+userId);
	}
	
	@Autowired
	private UserDao dao;
}
