package com.tianyl.conf;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DubboHealthIndicator extends AbstractHealthIndicator implements ApplicationContextAware {

	private ApplicationContext context;

    @Override
    protected void doHealthCheck(Builder builder) throws Exception {
        builder.up();
		// Map<String, ReferenceBean> map = SpringContextHolder.getBeansOfType(ReferenceBean.class);
		// for (ReferenceBean bean : map.values()) {
		// System.out.println(bean.getObjectType());
		// try {
		// Object obj = bean.getObject();
		// if (obj instanceof EchoService) {
		// System.out.println(((EchoService) obj).$echo("hi"));
		// }
		// } catch (Exception e) {
		// // e.printStackTrace();
		// System.out.println("error");
		// }
		// }
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

}
