package com.tianyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.tianyl.bean.FooBean;
import com.tianyl.bean.FooBean2;

@SpringBootApplication
@EntityScan(basePackages = { "com.tianyl" })
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		FooBean foo = context.getBean(FooBean.class);
		System.out.println(foo.getName());
		System.out.println(foo.getPrivateFooName());
		System.out.println(foo.getPrivateabcFooName());
		FooBean2 foo2 = context.getBean(FooBean2.class);
		System.out.println(foo2.getFooName());
		// context.close();
	}

}
