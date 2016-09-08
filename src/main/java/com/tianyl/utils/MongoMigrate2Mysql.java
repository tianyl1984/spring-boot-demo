package com.tianyl.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.UUID;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoMigrate2Mysql {

	public static void main(String[] args) throws Exception {
		// m1();
		m2();
	}

	private static void m2() throws Exception {
		DBCollection coll = MongoUtil.getDbCollection("172.16.40.29", "wooyun", "wooyun_list");
		Connection conn = SqlHelper.getMysqlConnection("127.0.0.1", "wooyun", "root", "ufenqi@321");
		PreparedStatement ps = conn.prepareStatement("insert into bugs(bugType,author,wyid,url,title,`datetime`,datetimeopen,delFlag) values(?,?,?,?,?,?,?,?)");
		DBCursor cursor = coll.find();
		int index = 0;
		while (cursor.hasNext()) {
			DBObject dbObj = cursor.next();
			String bugType = dbObj.get("bug_type").toString();
			String author = dbObj.get("author").toString();
			String wyid = dbObj.get("wooyun_id").toString();
			String title = dbObj.get("title").toString();
			Date dateTime = (Date) dbObj.get("datetime");
			Date dateTimeOpen = (Date) dbObj.get("datetime_open");
			String html = dbObj.get("html").toString();
			String newurl = "/bugs/" + UUID.randomUUID().toString() + ".html";
			FileUtil.saveToFile(html.getBytes("utf-8"), new File("d:/aaaa" + newurl));
			ps.setString(1, bugType);
			ps.setString(2, author);
			ps.setString(3, wyid);
			ps.setString(4, newurl);
			ps.setString(5, title);
			ps.setObject(6, dateTime);
			ps.setObject(7, dateTimeOpen);
			ps.setBoolean(8, false);
			ps.addBatch();
			if (index % 100 == 0) {
				ps.executeBatch();
				System.out.println("save batch:" + index);
			}
			index++;
		}
		ps.executeBatch();
		System.out.println("完成：" + index);
	}

	private static void m1() throws Exception {
		DBCollection coll = MongoUtil.getDbCollection("172.16.40.29", "wooyun", "wooyun_drops");
		Connection conn = SqlHelper.getMysqlConnection("127.0.0.1", "wooyun", "root", "ufenqi@321");
		PreparedStatement ps = conn.prepareStatement("insert into drops(category,author,wyurl,url,title,`datetime`,delFlag) values(?,?,?,?,?,?,?)");
		DBCursor cursor = coll.find();
		int index = 0;
		while (cursor.hasNext()) {
			DBObject dbObj = cursor.next();
			String category = dbObj.get("category").toString();
			String author = dbObj.get("author").toString();
			String url = dbObj.get("url").toString();
			String title = dbObj.get("title").toString();
			Date dateTime = (Date) dbObj.get("datetime");
			String html = dbObj.get("html").toString();
			String newurl = "/drops/" + UUID.randomUUID().toString() + ".html";
			FileUtil.saveToFile(html.getBytes("utf-8"), new File("d:/aaaa" + newurl));
			ps.setString(1, category);
			ps.setString(2, author);
			ps.setString(3, url);
			ps.setString(4, newurl);
			ps.setString(5, title);
			ps.setObject(6, dateTime);
			ps.setBoolean(7, false);
			ps.addBatch();
			if (index % 100 == 0) {
				ps.executeBatch();
				System.out.println("save batch:" + index);
			}
			index++;
		}
		ps.executeBatch();
		System.out.println("完成：" + index);
	}

}
