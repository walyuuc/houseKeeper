package com.chy.manager;

import com.chy.common.Page;
import com.chy.entity.User;

public interface RelativeMng {

	public Page getByEmployee(Long employeeId,Page page);
	
	public User getByEmployer(Long employerId);
}
