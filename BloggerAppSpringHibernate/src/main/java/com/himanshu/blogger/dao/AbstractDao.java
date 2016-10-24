package com.himanshu.blogger.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao <PK extends Serializable, T>{
	
	private final Class<T> persistantClass;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistantClass=(Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		System.out.println("save 8");
		return (T) getSession().get(persistantClass, key);
	}
	
	public void persistEntity(T entity) {
		System.out.println("save 5");
		this.getSession().persist(entity);
	}

	public void deleteEntity(T entity) {
		this.getSession().delete(entity);
	}
	
	public void updateEntity(T entity) {
		getSession().update(entity);
	}

	protected Criteria createEntityCriteria() {
		return this.getSession().createCriteria(persistantClass);
	}
}
