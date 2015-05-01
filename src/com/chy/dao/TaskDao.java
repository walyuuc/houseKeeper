package com.chy.dao;

import com.chy.common.Page;
import com.chy.entity.Task;

public interface TaskDao {

	public Page get(Long employerId,Long employeeId,Page page);
	
	public void save(Task task);
}
