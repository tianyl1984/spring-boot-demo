package com.tianyl.bean;

import org.springframework.stereotype.Component;

@Component
public class FooBean2 {

	private String fooName;

	private Integer fooAge;

	public String getFooName() {
		return fooName;
	}

	public void setFooName(String fooName) {
		this.fooName = fooName;
	}

	public Integer getFooAge() {
		return fooAge;
	}

	public void setFooAge(Integer fooAge) {
		this.fooAge = fooAge;
	}

}
