package com.sotuzun.classroom.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Course dto.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
public class CourseDto implements Serializable {

	private static final long serialVersionUID = 272531382158878696L;

	public static CourseDto NOT_FOUND = null;

	private Integer id;
	private String code;
	private String name;
	private List<StudentDto> students;

	public CourseDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}
}
