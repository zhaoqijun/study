package com.study.customerService.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.customerService.bean.User;
import com.study.customerService.dao.UserDao;

@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	protected Session getSession() {
		return entityManagerFactory.unwrap(SessionFactory.class).openSession();// 这种方式需要手动关闭session
		// 这种方式会自动关闭session，但是要配置current_session_context_class，并且需要使用事务
		// return entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	@Override
	public List<User> findByName(String name) {

		Query query = getSession().createNativeQuery("select * from fos.t_user where name=:name", User.class);

		query.setParameter("name",name);

		List<User> userList = query.getResultList();
		
		return userList;

	}
	
	@Override
	public List<User> findAll() {

		Query query = getSession().createNativeQuery("select * from fos.t_user", User.class);

		List<User> userList = query.getResultList();
		
		getSession().close();

		return userList;

	}

}
