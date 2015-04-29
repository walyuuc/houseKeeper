package com.chy.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.RelativeDao;
import com.chy.dao.UserDao;
import com.chy.manager.RelativeMng;

@Service
public class RelativeMngImpl implements RelativeMng {

	public Page getByEmployee(Long employeeId,Page page){
		page=dao.getByEmployee(null, employeeId, page);
		return page;
	}
	
	public Page getByEmployer(Long employerId,Page page){
		page=dao.getByEmployee(employerId, null, page);
		return page;
	}
	
	@Autowired
	private RelativeDao dao;
	@Autowired
	private UserDao userDao;
}

