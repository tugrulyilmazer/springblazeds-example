package com.sotuzun.classroom.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Generic dao.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
public interface GenericDao<T, PK extends Serializable> {

	PK persist(T newInstance);

	void update(T transientObject);

	public T merge(T entity);

	void saveOrUpdate(T entity);

	void saveOrUpdateAll(Collection<T> entityCollection);

	void deleteById(PK id);

	void delete(T persistentObject);

	void deleteAll();

	void deleteAll(Collection<T> persistentObjects);

	T get(PK id);

	T load(PK id);

	Collection<T> loadAll();

	List<T> findAll();

	List<T> findByExample(T exampleInstance);

	List<T> findByCriteria(DetachedCriteria criteria);

	List<T> findByCriteria(Criterion... criterion);

	void flush();

	void clear();

	void initialize(Object proxy);

	void refresh(T entity);
}
