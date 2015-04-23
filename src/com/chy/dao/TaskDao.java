package com.chy.dao;

import com.chy.common.Page;

public interface TaskDao {

	public Page getByEmployee(Long employeeId,Page page);
}
