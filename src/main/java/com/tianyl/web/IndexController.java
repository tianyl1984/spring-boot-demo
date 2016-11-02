package com.tianyl.web;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyl.bean.BarBean;
import com.tianyl.bean.User;
import com.tianyl.bean.UserInfo;
import com.tianyl.utils.DateUtil;
import com.tianyl.utils.WebContextHolder;
import com.tianyl.utils.WebUtil;

@Controller
public class IndexController {

	@Autowired
	private Validator validator;

	@RequestMapping("index")
	public String index() {
		HttpServletRequest request = WebContextHolder.getRequest();
		request.setAttribute("bar", new BarBean("zhangsan in request"));
		return "index";
	}

	@RequestMapping("index2")
	@ResponseBody
	public String index2(User user) {
		Set<ConstraintViolation<User>> validatorResult = validator.validate(user);
		if (validatorResult != null && !validatorResult.isEmpty()) {
			StringBuffer errorInfo = new StringBuffer();
			for (ConstraintViolation<User> vc : validatorResult) {
				String msg = vc.getMessage();
				errorInfo.append(vc.getPropertyPath() + ":" + msg);
			}
			return errorInfo.toString();
		}
		return "ok";
	}

	@RequestMapping("m1")
	@ResponseBody
	public Object m1(User user) {
		System.out.println(user.getDate());
		return "ok";
	}

	@RequestMapping("m2")
	@ResponseBody
	public Object m2(UserInfo user) {
		System.out.println(user.getName());
		return "ok m2";
	}
	
	@RequestMapping("readBody")
	@ResponseBody
	public Object readBody(@RequestBody String body, HttpServletRequest request) {
		System.out.println("Controller内读取body：" + body);
		String str = WebUtil.readBody(request);
		System.out.println("Controller内再次读取body：" + str);
		return "read body ok";
	}

	@RequestMapping("errorDemo")
	public Object errorDemo() throws Exception {
		// new ArrayList<String>().get(1);
		Class.forName("bbbbbbbbbbbbb");
		return "ok";
	}

	@RequestMapping("aaa")
	@ResponseBody
	public Object aaa(Date d) {
		return "ok:" + DateUtil.format(d);
	}

}
