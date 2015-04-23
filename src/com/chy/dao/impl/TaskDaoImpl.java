package com.chy.dao.impl;

import org.springframework.stereotype.Repository;

import com.chy.common.Finder;
import com.chy.common.HibernateSimpleDao;
import com.chy.common.Page;
import com.chy.dao.TaskDao;

@Repository
public class TaskDaoImpl extends HibernateSimpleDao implements TaskDao{

	public Page getByEmployee(Long employeeId,Page page){
		String sql="from Task bean where bean.employee.id=:employeeId";
		Finder f=Finder.create(sql);
		f.setParam("employeeId", employeeId);
		return find(f, page.getPageNo(), page.getPageSize());
	}
	
}
