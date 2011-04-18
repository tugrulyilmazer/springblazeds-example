package com.sotuzun.classroom.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sotuzun.classroom.dao.GenericDao;

/**
 * Hibernate implementation of generic dao.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
@SuppressWarnings("unchecked")
public class GenericDaoHibernateImpl<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {

	private Class<T> persistentClass;

	public GenericDaoHibernateImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void bindSessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public Class<T> getPersistenClass() {
		return persistentClass;
	}

	public void setPersistenceClass(Class<T> persistenceClass) {
		this.persistentClass = persistenceClass;
	}

	public PK persist(T newInstance) {
		return (PK) getHibernateTemplate().save(newInstance);
	}

	public void update(T transientObject) {
		getHibernateTemplate().update(transientObject);
	}

	public T merge(T entity) {
		return getHibernateTemplate().merge(entity);
	}

	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<T> entityCollection) {
		getHibernateTemplate().saveOrUpdateAll(entityCollection);
	}

	public void delete(T persistentObject) {
		getHibernateTemplate().delete(persistentObject);
	}

	public void deleteById(PK id) {
		getHibernateTemplate().delete(load(id));
	}

	public void deleteAll() {
		getHibernateTemplate().bulkUpdate("delete from " + persistentClass.getSimpleName());
	}

	public void deleteAll(Collection<T> persistentObjects) {
		getHibernateTemplate().deleteAll(persistentObjects);
	}

	public T get(PK id) {
		return (T) getHibernateTemplate().get(persistentClass, id);
	}

	public T load(PK id) {
		return (T) getHibernateTemplate().load(persistentClass, id);
	}

	public Collection<T> loadAll() {
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(persistentClass));
	}

	public List<T> findAll() {
		return getHibernateTemplate().find("from " + persistentClass.getName());
	}

	public List<T> findByExample(T exampleInstance) {
		return getHibernateTemplate().findByExample(exampleInstance);
	}

	public List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List<T> findByCriteria(Criterion... criterion) {
		Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(persistentClass);

		for (Criterion c : criterion) {
			criteria.add(c);
		}

		return criteria.list();
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	public void clear() {
		getHibernateTemplate().clear();
	}

	public void initialize(Object proxy) {
		getHibernateTemplate().initialize(proxy);
	}

	public void refresh(T entity) {
		getHibernateTemplate().refresh(entity);
	}
}
