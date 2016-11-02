package com.tianyl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String format(Date date) {
		if (date == null) {
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

}
