package com.chy.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chy.common.Page;
import com.chy.dao.TaskDao;
import com.chy.entity.Task;
import com.chy.manager.TaskMng;

@Service
public class TaskMngImpl implements TaskMng{

	public Page getByEmployee(Long employeeId,Page page){
		page.init(page.getPageSize(), dao.getCount(employeeId));
		List<Task> taskList=dao.getByEmployee(employeeId, page);
		page.setList(taskList);
		return page;
	}
	
	@Autowired
	private TaskDao dao;
}
