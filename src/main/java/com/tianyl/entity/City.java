package com.tianyl.entity;

import org.springframework.data.annotation.Id;

public class City {

	@Id
	private String id;

	private String name;

	public City() {

	}

	public City(String name) {
		super();
		this.name = name;
	}

	public City(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
