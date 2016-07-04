package com.tianyl.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianyl.bean.BarBean;
import com.tianyl.utils.WebContextHolder;

@Controller
public class IndexController {

	@RequestMapping("index")
	public String index() {
		HttpServletRequest request = WebContextHolder.getRequest();
		request.setAttribute("bar", new BarBean("zhangsan in request"));
		return "index";
	}

}
