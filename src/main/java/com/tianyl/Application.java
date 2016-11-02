package com.tianyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.bean.FooBean;

@SpringBootApplication
@EntityScan(basePackages = { "com.tianyl" })
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
		context.getBean(FooBean.class).getName();
	}

}
