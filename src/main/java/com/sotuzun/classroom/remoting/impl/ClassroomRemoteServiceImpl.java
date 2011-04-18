package com.sotuzun.classroom.remoting.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Component;

import com.sotuzun.classroom.domain.Course;
import com.sotuzun.classroom.dto.CourseDto;
import com.sotuzun.classroom.remoting.ClassroomRemoteService;
import com.sotuzun.classroom.service.CourseService;

/**
 * Classroom remoting service implementation.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
@Component
@RemotingDestination
public class ClassroomRemoteServiceImpl implements ClassroomRemoteService {

	@Autowired
	private CourseService courseService;

	@Autowired
	private Mapper mapper;

	@RemotingInclude
	public CourseDto getCourseById(Integer id) {
		Course course = courseService.getCourse(id);

		if (course != null) {
			return mapper.map(course, CourseDto.class);
		} else {
			return CourseDto.NOT_FOUND;
		}
	}
}
