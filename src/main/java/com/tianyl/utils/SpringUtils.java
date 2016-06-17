package com.tianyl.utils;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tianyl.bean.FooBean;

public class SpringUtils {

	public static void renderJson(HttpServletResponse response, FooBean foo) {
		String json = JSON.toJSONString(foo);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
