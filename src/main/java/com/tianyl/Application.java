package com.tianyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.bean.FooBean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		FooBean foo = context.getBean(FooBean.class);
		System.out.println(foo.getName());

		context.close();
	}

}
