package com.tianyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EntityScan(basePackages = { "com.tianyl" })
@EnableRedisHttpSession
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		// BarMapper barMapper = context.getBean(BarMapper.class);
		// System.out.println(barMapper);
		// System.out.println(barMapper.selectAll());
	}

}
