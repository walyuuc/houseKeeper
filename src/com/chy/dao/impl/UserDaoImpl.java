package com.chy.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chy.dao.UserDao;
import com.chy.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	public User getById(Integer id) {
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
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	private SessionFactory sessionFactory;

}
