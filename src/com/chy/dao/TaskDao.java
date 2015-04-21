package com.chy.dao;

import java.util.List;

import com.chy.common.Page;
import com.chy.entity.Task;

public interface TaskDao {

	public List<Task> getByEmployee(Long employeeId,Page page);
	
	public int getCount(Long employeeId) ;
}
