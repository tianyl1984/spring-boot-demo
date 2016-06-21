package com.tianyl.conf.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tianyl.bean.BarBean;

/**
 * 按条件初始化bean
 * 
 * @author user
 * @ConditionalOnBean（仅仅在当前上下文中存在某个对象时，才会实例化一个Bean）
 * @ConditionalOnClass（某个class位于类路径上，才会实例化一个Bean）
 * @ConditionalOnExpression（当表达式为true的时候，才会实例化一个Bean）
 * @ConditionalOnMissingBean（仅仅在当前上下文中不存在某个对象时，才会实例化一个Bean）
 * @ConditionalOnMissingClass（某个class类路径上不存在的时候，才会实例化一个Bean）
 * @ConditionalOnNotWebApplication（不是web应用）
 */
@Configuration
public class ConditionalDemo {

	@Bean
	@ConditionalOnMissingClass(name = { "com.tianyl.entity.AaaBarEntity" })
	public BarBean newBarBean() {
		System.out.println("初始化bar bean");
		BarBean bb = new BarBean();
		bb.setName("bar");
		return bb;
	}

}
