package com.tianyl.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * 
 * @author tianyale 2016年6月13日
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws Exception {
		logger.error("访问出错：" + req.getRequestURL());
		logger.error(e.getMessage(), e);
		ModelAndView mav = new ModelAndView();
		String ajaxHeader = req.getHeader("x-requested-with");
		if (StringUtils.isBlank(ajaxHeader)) {
			mav.addObject("exception", e);
			mav.addObject("url", req.getRequestURL());
			mav.setViewName(DEFAULT_ERROR_VIEW);
		} else {// ajax请求
		// mav.addAllObjects(ResponseJsonUtils.getUnknowErrorMap("错误：" + e.getMessage()));
		// mav.setView(new MappingJackson2JsonView());
		}

		return mav;
	}

}
