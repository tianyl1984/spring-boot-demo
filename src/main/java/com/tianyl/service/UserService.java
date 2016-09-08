package com.tianyl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private BarService barService;

	public void m1() {
		System.out.println(barService);
	}
}
