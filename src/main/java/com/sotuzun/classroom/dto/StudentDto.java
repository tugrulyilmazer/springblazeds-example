package com.sotuzun.classroom.dto;

import java.io.Serializable;

/**
 * Student dto.
 * 
 * @author sotuzun
 * @version 1.0.0
 * @since 17/04/2011 01:27 AM
 */
public class StudentDto implements Serializable {

	private static final long serialVersionUID = 5676537610205056520L;

	private Integer id;
	private String name;
	private String surname;

	public StudentDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
