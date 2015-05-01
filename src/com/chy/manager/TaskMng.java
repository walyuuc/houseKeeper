package com.chy.manager;

import javax.servlet.http.HttpServletRequest;

import com.chy.common.Page;

public interface TaskMng {

	public Page getByEmployee(Long employeeId,Page page);
	
	public Page getByEmployer(Long employerId,Page page);
	
	public void releaseTask(Byte type,HttpServletRequest request);
}
