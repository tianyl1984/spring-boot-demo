package com.tianyl.conf;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class WebContextHolderListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		sre.getServletRequest();
		// System.out.println("requestInitialized");
	}

}
