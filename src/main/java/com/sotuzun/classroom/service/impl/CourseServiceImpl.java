package com.sotuzun.classroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sotuzun.classroom.dao.CourseDao;
import com.sotuzun.classroom.domain.Course;
import com.sotuzun.classroom.service.CourseService;

/**
 * Course service implementation.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public Course getCourse(Integer id) {
		return courseDao.get(id);
	}
}
