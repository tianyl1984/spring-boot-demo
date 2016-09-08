package com.tianyl.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	// @Valid
	// @Length(max = 5)
	private String username;

	private Integer age;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
