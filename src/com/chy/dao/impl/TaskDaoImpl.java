package com.chy.dao.impl;

import org.springframework.stereotype.Repository;

import com.chy.common.Finder;
import com.chy.common.HibernateSimpleDao;
import com.chy.common.Page;
import com.chy.dao.TaskDao;
import com.chy.entity.Task;

@Repository
public class TaskDaoImpl extends HibernateSimpleDao implements TaskDao{

	public Page get(Long employerId,Long employeeId,Page page){
		String sql="from Task bean where 1=1";
		Finder f=Finder.create(sql);
		if(employerId!=null){
			f.append(" and bean.employer.id=:employerId");
			f.setParam("employerId", employerId);
		}
		if(employeeId!=null){
			f.append(" and bean.employee.id=:employeeId");
			f.setParam("employeeId", employeeId);
		}
		return find(f, page.getPageNo(), page.getPageSize());
	}
	
	public void save(Task task){
		Long row=(Long) getSession().save(task);
		System.out.println(row);
	}
	
}
