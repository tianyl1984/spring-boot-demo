package com.tianyl.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "foo")
public class FooBean {

	private String name;

	private Integer age;

	private String privateFooName;

	private String privateabcFooName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPrivateFooName() {
		return privateFooName;
	}

	public void setPrivateFooName(String privateFooName) {
		this.privateFooName = privateFooName;
	}

	public String getPrivateabcFooName() {
		return privateabcFooName;
	}

	public void setPrivateabcFooName(String privateabcFooName) {
		this.privateabcFooName = privateabcFooName;
	}

}
