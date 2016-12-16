package com.tianyl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping("/ajaxStr")
	@ResponseBody
	public Object str() {
		return "ok";
	}

}
