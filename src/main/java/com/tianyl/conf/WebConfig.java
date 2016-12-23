package com.tianyl.conf;

import java.util.EventListener;

import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ServletListenerRegistrationBean<EventListener> listener() {
		ServletListenerRegistrationBean<EventListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new WebContextHolderListener());
		return bean;
	}

	@Bean
	public ServletListenerRegistrationBean<EventListener> sessionListener() {
		ServletListenerRegistrationBean<EventListener> bean = new ServletListenerRegistrationBean<>();
		bean.setListener(new CustomHttpSessionListener());
		return bean;
	}

}
