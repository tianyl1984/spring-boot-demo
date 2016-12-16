package com.tianyl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class Test {

	public static void main(String[] args) throws Exception {
		// m1();
		String msg = "{\"message\":\"success\",\"status\":200}";
		String str = JSONObject.parseObject(msg).getString("status");
		System.out.println("200".equals(str));
	}

	private static void m1() throws Exception {
		String path = "C:\\Users\\user\\Desktop\\aa\\fe_teacher";
		String pkgStr = readFile(path + "\\package.json");
		JSONObject jsonAll = JSONObject.parseObject(pkgStr);
		JSONObject jsonDep = jsonAll.getJSONObject("devDependencies");
		for (String key : jsonDep.keySet()) {
			String version = getVersion(key);
			System.out.println("\"" + key + "\":\"" + version + "\",");
		}

	}

	private static String getVersion(String key) throws Exception {
		String str = getNetResponse("http://139.196.148.113:8123/" + key + "/package.json");
		return JSONObject.parseObject(str).getString("version");
	}

	private static String getNetResponse(String url) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		// POST必须大写
		conn.setRequestMethod("GET");
		conn.setUseCaches(false);
		// 仅对当前请求自动重定向
		conn.setInstanceFollowRedirects(false);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.connect();

		// System.out.println("-----Response Content-----");
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String result = "";
		String temp = null;
		while ((temp = reader.readLine()) != null) {
			result += temp + "\n";
		}
		reader.close();
		// System.out.println(result);
		// System.out.println("-----Response Content-----");

		conn.disconnect();
		return result;
	}

	private static String readFile(String path) throws Exception {
		FileReader fr = new FileReader(new File(path));
		BufferedReader br = new BufferedReader(fr);
		String result = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			result += line;
		}
		br.close();
		return result;
	}

}
