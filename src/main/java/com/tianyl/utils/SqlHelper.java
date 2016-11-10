package com.tianyl.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {

	// public static void main(String[] args) throws Exception {
	// printSql();
	// }

	public static String getSqlValue(String val) {
		return val.replaceAll("'", "''");
	}

	public static List<String> getColumnLabel(ResultSet rs) throws SQLException {
		List<String> result = new ArrayList<String>();
		ResultSetMetaData metaData = rs.getMetaData();
		for (int col = 1; col <= metaData.getColumnCount(); col++) {
			String label = metaData.getColumnLabel(col);
			result.add(label);
		}
		return result;
	}

	public static List<Integer> getColumnType(ResultSet rs) throws SQLException {
		List<Integer> result = new ArrayList<Integer>();
		ResultSetMetaData metaData = rs.getMetaData();
		for (int col = 1; col <= metaData.getColumnCount(); col++) {
			result.add(metaData.getColumnType(col));
		}
		return result;
	}

	private static void printSql() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\workspace3.7\\ScoreExport\\src\\com\\unitever\\cydc\\sql.txt")), "utf-8"));
		String temp = null;
		System.out.println("StringBuffer sqlBuffer = new StringBuffer();");
		while ((temp = br.readLine()) != null) {
			System.out.println("sqlBuffer.append(\" " + temp + " \");");
		}
		br.close();
	}

	public static Connection getSqlServerSaConnection(String ip, String database) throws ClassNotFoundException, SQLException {
		return getSqlServerConnection(ip, database, "sa", "hzth-801");
	}

	public static Connection getSqlServerSaLocalConnection(String database) throws ClassNotFoundException, SQLException {
		return getSqlServerConnection("127.0.0.1", database, "sa", "hzth-801");
	}

	public static Connection getSqlServerConnection(String ip, String database, String userName, String password) throws ClassNotFoundException, SQLException {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://" + ip + ";database=" + database + ";sendStringParametersAsUnicode=false";
		return getConnection(driver, url, userName, password);
	}

	public static Connection getMysqlConnection(String ip, String database, String userName, String password) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://" + ip + ":3306/" + database + "?useUnicode=true&characterEncoding=utf-8";
		return getConnection(driver, url, userName, password);
	}

	public static Connection getOracleConnection(String ip, String database, String userName, String password) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@" + ip + ":1521:" + database;
		return getConnection(driver, url, userName, password);
	}

	public static Connection getConnection(String driver, String url, String userName, String password) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, userName, password);
	}

	public static ResultSet getResultSet(Connection conn, String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<String> simpleSqlQueryAndCloseConn(Connection conn, String sql) throws Exception {
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<String> result = new ArrayList<>();
		while (rs.next()) {
			result.add(rs.getString(1));
		}
		close(conn);
		return result;
	}

	public static void executeSimpleSqlsAndCloseConn(Connection conn, String... sqls) throws Exception {
		for (String sql : sqls) {
			conn.prepareStatement(sql).execute();
		}
		close(conn);
	}

	public static Connection getMysqlConnection(String ip, int port, String database, String userName, String password) throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=utf-8";
		return getConnection(driver, url, userName, password);
	}
}
