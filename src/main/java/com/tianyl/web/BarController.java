package com.tianyl.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianyl.bean.FooBean;
import com.tianyl.entity.BarEntity;
import com.tianyl.service.BarService;
import com.tianyl.utils.SpringUtils;

@Controller
@RequestMapping("/bar")
public class BarController {

	@Autowired
	private FooBean foo;

	@Autowired
	private BarService barService;

	@RequestMapping("/get")
	public void get(HttpServletResponse response) {
		SpringUtils.renderJson(response, foo);
	}

	@RequestMapping("/list")
	public void list(HttpServletResponse response) {
		List<BarEntity> list = barService.findAll();
		SpringUtils.renderJson(response, list);
	}

	@RequestMapping("/save")
	public void save(HttpServletResponse response) {
		BarEntity entity = new BarEntity();
		entity.setName("张三");
		entity.setAge(10);
		barService.save(entity);
		SpringUtils.renderJson(response, "ok");
	}
}
