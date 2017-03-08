package com.tianyl.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public static void printHeader(HttpServletRequest req) {
		System.out.println("----------> Header start <----------");
		Enumeration<?> e = req.getHeaderNames();
		while (e.hasMoreElements()) {
			String header = e.nextElement().toString();
			String val = "";
			Enumeration<?> e2 = req.getHeaders(header);
			while (e2.hasMoreElements()) {
				val += "[" + e2.nextElement().toString() + "]";
			}
			System.out.println(header + ":" + val);
		}
		System.out.println("----------> Header end <----------");
	}

	public static void printParameter(HttpServletRequest req) {
		System.out.println("----------> Parameter start <----------");
		try {
			Enumeration<?> e = req.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement().toString();
				String value = "";
				String[] strs = req.getParameterValues(name);
				for (String str : strs) {
					value += "[" + str + "]";
				}
				System.out.println(name + ":" + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("----------> Parameter end <----------");
	}

	public static void printSession(HttpSession session) {
		System.out.println("------------> Session start  <--------------");
		Enumeration<?> e3 = session.getAttributeNames();
		while (e3.hasMoreElements()) {
			String name = e3.nextElement().toString();
			Object value = session.getAttribute(name);
			System.out.println(name + ":" + value);
		}
		System.out.println("------------>  Session end  <--------------");
	}

	public static void printStream(HttpServletRequest req) throws IOException {
		System.out.println("------------>  InputStream start  <--------------");
		InputStream in = req.getInputStream();
		byte[] buffer = new byte[1024];
		int hasRead = -1;
		while ((hasRead = in.read(buffer)) != -1) {
			System.out.println(new String(Arrays.copyOf(buffer, hasRead)));
		}
		System.out.println("------------>  InputStream end  <--------------");
	}

}
