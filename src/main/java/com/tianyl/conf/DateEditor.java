package com.tianyl.conf;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.trim().length() == 0) {
			return;
		}
		text = text.trim();
		Date date = null;
		if (text.length() == 19) {
			List<String> formats = Arrays.asList("yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy\\MM\\dd HH:mm:ss");
			date = parseToDate(formats, text);
		}
		if (text.length() == 16) {
			List<String> formats = Arrays.asList("yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm", "yyyy\\MM\\dd HH:mm");
			date = parseToDate(formats, text);
		}
		if (text.length() == 10) {
			List<String> formats = Arrays.asList("yyyy-MM-dd", "yyyy/MM/dd", "yyyy\\MM\\dd");
			date = parseToDate(formats, text);
		}
		if (text.length() == 7) {
			List<String> formats = Arrays.asList("yyyy-MM", "yyyy/MM", "yyyy\\MM");
			date = parseToDate(formats, text);
		}
		if (date == null) {
			throw new IllegalArgumentException("Could not parse date: " + text);
		}
		setValue(date);
	}

	private Date parseToDate(List<String> formats, String text) {
		for (String format : formats) {
			try {
				return new SimpleDateFormat(format).parse(text);
			} catch (ParseException e) {
			}
		}
		return null;
	}

	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		if (value == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(value);
	}
}
