package com.tianyl.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	public static void main(String[] args) {
		Student stu = new Student();
		stu.setaName("zhangsan");
		System.out.println(JSONObject.toJSONString(stu));
	}

}

class Student {

	private String aName;

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

}