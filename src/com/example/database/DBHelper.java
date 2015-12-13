package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	public static final String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "zwo03l0w45";
	public static final String password = "wjzj2x1514lwxlw4xj2ix0wkj22h2ww314w03j4h";

	public static Connection conn = null;
	public static PreparedStatement pst = null;
	public static Statement st = null;
	
	public DBHelper(String string) {
		try {
			Class.forName(name).newInstance();// 指定连接类型
			conn = DriverManager.getConnection(url + string, user, password);// 获取连接
//			pst = conn.prepareStatement(sql);// 准备执行语句
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			this.conn.close();
//			this.pst.close();
			this.st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
