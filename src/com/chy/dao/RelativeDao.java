package com.chy.dao;

import java.util.List;

import com.chy.common.Page;
import com.chy.entity.Relative;

public interface RelativeDao {

	public List<Relative> getByEmployee(Long employeeId, Page page);
	
	public int getCount(Long employeeId);
}
