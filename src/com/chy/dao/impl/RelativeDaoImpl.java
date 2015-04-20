package com.chy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chy.common.Page;
import com.chy.dao.RelativeDao;
import com.chy.entity.Relative;

@Repository
public class RelativeDaoImpl implements RelativeDao {

	public List<Relative> getByEmployee(Long employeeId, Page page) {
		Query query = getSession().createQuery(
				"from Relative bean where bean.employeeId=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	public int getCount(Long employeeId) {
		Query query = getSession().createQuery(
						"select count(*) from Relative bean " +
						"where bean.employeeId=:employeeId");
		query.setParameter("employeeId", employeeId);
		return ((Number) (query.iterate().next())).intValue();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private SessionFactory sessionFactory;
}
