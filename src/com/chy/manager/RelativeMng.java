package com.chy.manager;

import com.chy.common.Page;

public interface RelativeMng {

	public Page getByEmployee(Long employeeId,Page page);
	
	public Page getByEmployer(Long employerId,Page page);
}
