package com.chy.manager.impl;

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
		page=dao.getByEmployee(null, employeeId, page);
		return page;
	}
	
	public User getByEmployer(Long employerId){
		Page page=new Page();
		page=dao.getByEmployee(employerId, null, page);
		return  ((Relative)page.getList().get(0)).getEmployee();
	}
	
	@Autowired
	private RelativeDao dao;
	@Autowired
	private UserDao userDao;
}

