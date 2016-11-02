package com.tianyl.conf;

import java.util.Date;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class WebDataBinderConfig {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 字符串去空格
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
		// 时间转换
		// DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		// CustomDateEditor editor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}
