package com.chy.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.RelativeDao;
import com.chy.dao.UserDao;
import com.chy.entity.Relative;
import com.chy.entity.User;
import com.chy.manager.RelativeMng;

@Service
public class RelativeMngImpl implements RelativeMng {

	public Page getByEmployee(Long employeeId,Page page){
		page.init(page.getPageSize(),dao.getCount(employeeId));
		List<Relative> relList=dao.getByEmployee(employeeId,page);
		List<User> userList=new ArrayList<User>();
		for(int i=0;i<relList.size();i++){
			userList.add(userDao.getById(relList.get(i).getEmployerId()));
		}
		page.setList(userList);
		return page;
	}
	
	@Autowired
	private RelativeDao dao;
	@Autowired
	private UserDao userDao;
}

