package com.chy.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.TaskDao;
import com.chy.manager.TaskMng;

@Service
public class TaskMngImpl implements TaskMng{

	public Page getByEmployee(Long employeeId,Page page){
		page=dao.getByEmployee(employeeId, page);
		return page;
	}
	
	@Autowired
	private TaskDao dao;
}
