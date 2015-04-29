package com.chy.dao.impl;

import org.springframework.stereotype.Repository;

import com.chy.common.Finder;
import com.chy.common.HibernateSimpleDao;
import com.chy.common.Page;
import com.chy.dao.RelativeDao;

@Repository
public class RelativeDaoImpl extends HibernateSimpleDao implements RelativeDao {

	public Page getByEmployee(Long employerId, Long employeeId, Page page) {
		Finder f=Finder.create("from Relative bean where 1=1");
		if(employeeId!=null){
			f.append(" and bean.employee.id=:employeeId");
			f.setParam("employeeId", employeeId);
		}
		if(employerId!=null){
			f.append(" and bean.employer.id=:employerId");
			f.setParam("employerId", employerId);
		}
		return find(f, page.getPageNo(), page.getPageSize());
	}

}
