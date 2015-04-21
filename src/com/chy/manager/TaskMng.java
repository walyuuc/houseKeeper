package com.chy.manager;

import com.chy.common.Page;

public interface TaskMng {

	public Page getByEmployee(Long employeeId,Page page);
}
