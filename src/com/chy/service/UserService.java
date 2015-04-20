package com.chy.service;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chy.dao.UserDao;
import com.chy.entity.User;
import com.chy.manager.UserMng;
import com.chy.security.Md5PwdEncoder;
import com.chy.security.PwdEncoder;

@Component("userService")
public class UserService {

	public String getById(Long id) {
		User user = dao.getById(id);
		return JSONObject.fromObject(user).toString();
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
	
	public User update(User user){
		return dao.update(user);
	}
	
	@Autowired
	private UserDao dao;
	@Autowired
	private PwdEncoder pwdEncoder;
}
