package com.sotuzun.classroom.remoting;

import com.sotuzun.classroom.dto.CourseDto;

/**
 * Classroom remoting service.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
public interface ClassroomRemoteService {

	CourseDto getCourseById(Integer id);
}
