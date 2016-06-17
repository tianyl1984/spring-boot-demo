package com.tianyl.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianyl.bean.FooBean;
import com.tianyl.utils.SpringUtils;

@Controller
@RequestMapping("/bar")
public class BarController {

	@Autowired
	private FooBean foo;

	@RequestMapping("/get")
	public void get(HttpServletResponse response) {
		SpringUtils.renderJson(response, foo);
	}

}
