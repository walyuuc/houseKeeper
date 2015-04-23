package com.chy.dao;

import com.chy.common.Page;

public interface RelativeDao {

	public Page getByEmployee(Long employerId, Long employeeId, Page page) ;
	
}
