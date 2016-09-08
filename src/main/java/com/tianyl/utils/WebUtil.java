package com.tianyl.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static String readBody(HttpServletRequest request) {
		try {
			InputStream in = request.getInputStream();
			in.reset();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] bs = new byte[1024];
			int hasRead = -1;
			while ((hasRead = in.read(bs)) != -1) {
				baos.write(bs, 0, hasRead);
			}
			String str = new String(baos.toByteArray());
			in.reset();
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
