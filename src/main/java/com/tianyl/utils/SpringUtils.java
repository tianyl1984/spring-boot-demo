package com.tianyl.utils;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class SpringUtils {

	public static void renderJson(HttpServletResponse response, Object obj) {
		String json = JSON.toJSONString(obj);
		response.setContentType("application/json");
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
