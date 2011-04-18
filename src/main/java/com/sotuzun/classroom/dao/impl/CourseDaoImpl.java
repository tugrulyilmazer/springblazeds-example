package com.sotuzun.classroom.dao.impl;

import org.springframework.stereotype.Repository;

import com.sotuzun.classroom.dao.CourseDao;
import com.sotuzun.classroom.domain.Course;

/**
 * Course dao implementation.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
@Repository
public class CourseDaoImpl extends GenericDaoHibernateImpl<Course, Integer> implements CourseDao {

}
