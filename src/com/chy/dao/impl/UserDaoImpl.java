package com.chy.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.chy.common.Finder;
import com.chy.common.HibernateSimpleDao;
import com.chy.common.Page;
import com.chy.dao.UserDao;
import com.chy.entity.User;

@Repository
public class UserDaoImpl extends HibernateSimpleDao implements UserDao{

	public User getById(Long id) {
		User user=(User) getSession().get(User.class, id);
		return user;
	}

	public List<User> getList(){
		Query query=getSession().createQuery("from User");
		query.setCacheable(true);
		return query.list();
	}
	
	public Long save(User user){
		Long res=(Long) getSession().save(user);
		return res;
	}
	
	public User getByUsername(String username){
		Query query=getSession().createQuery("from User bean where bean.username=:username");
		query.setParameter("username", username);
		return (User) query.uniqueResult();
	}
	
	public User getByUsernameAndPassword(User user){
		Query query=getSession().createQuery("from User bean where bean.username=:username and bean.password=:password");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		return (User) query.uniqueResult();
	}
	
	public User update(User user){
		getSession().update(user);
		return user;
	}
	
	public void delete(Long userId){
		User user=(User) getSession().get(User.class, userId);
		if(user!=null){
			getSession().delete(user);
		}
	}
	
	public Page getFreeEmployer(Page page){
		String sql="from User bean " +
				"where bean.id not in (select rel.employer.id from Relative rel) " +
				"and bean.type=1";
		Finder f=Finder.create(sql);
		f.setCacheable(true);
		return find(f, page.getPageNo(), page.getPageSize());
	}
	
}
