package com.sotuzun.classroom.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sotuzun.classroom.dto.CourseDto;
import com.sotuzun.classroom.dto.StudentDto;
import com.sotuzun.classroom.remoting.ClassroomRemoteService;

/**
 * Classroom remoting service test.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class ClassroomRemoteServiceTest {

	private static Logger logger = Logger.getLogger(ClassroomRemoteService.class);

	@Autowired
	private ClassroomRemoteService classroomRemoteService;

	@Test
	public void getCourseByIdTest() {
		CourseDto course = classroomRemoteService.getCourseById(1);

		Assert.assertNotNull(course);
		Assert.assertEquals("CSE 211", course.getCode());
		Assert.assertEquals("Data Structures", course.getName());

		logger.info("Course: " + course.getCode() + " - " + course.getName());

		Assert.assertNotNull(course.getStudents());

		for (StudentDto student : course.getStudents()) {
			logger.info("Student: " + student.getName() + " " + student.getSurname());
		}
	}
}
