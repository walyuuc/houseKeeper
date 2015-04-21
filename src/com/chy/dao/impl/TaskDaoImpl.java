package com.chy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chy.common.Page;
import com.chy.dao.TaskDao;
import com.chy.entity.Task;

@Repository
public class TaskDaoImpl implements TaskDao{

	public List<Task> getByEmployee(Long employeeId,Page page){
		Query query=getSession().createQuery("from Task bean where bean.employee.id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}
	
	public int getCount(Long employeeId) {
		Query query = getSession().createQuery(
						"select count(*) from Task bean " +
						"where bean.employee.id=:employeeId");
		query.setParameter("employeeId", employeeId);
		return ((Number) (query.iterate().next())).intValue();
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
}
