package com.example.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

public class DataBaseDemo {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;

	// ��¼�˺�
	public String LoginDB(String username, String password,
			HttpServletResponse response) {
		if (RegistrQuery(username, password)) { // ���˺Ŵ���
			return PasswordDB(username, password, response); // �ж������Ƿ���ȷ
		}
		return "NO";
	}

	// ע���˺�
	public String RegistrDB(String username, String password) {
		if (!RegistrQuery(username, password)) { // ���˺�δע��
			return Registr(username, password);
		}
		return "NO";
	}

	// ��ѯ�˺��Ƿ�ע��
	private boolean RegistrQuery(String username, String password) {
		sql = "select * from account";// SQL���
		db1 = new DBHelper("myclient");// ����DBHelper����

		try {
			ret = db1.st.executeQuery(sql);// ִ����䣬�õ������
			while (ret.next()) {
				if (ret.getString(1).equals(username)) {
					return true;
				}
			}
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// ��ѯ�����Ƿ���ȷ
	private String PasswordDB(String username, String password,
			HttpServletResponse resp) {
		sql = "select * from account where phone = '" + username + "'";// SQL���
		db1 = new DBHelper("myclient");// ����DBHelper����

		try {
			ret = db1.st.executeQuery(sql);// ִ����䣬�õ������
			while (ret.next()) {
				System.out.println(ret.getString(2));
				if (ret.getString(2).equals(password)) {

					return "OK";
				}
			}
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "NOPassword";
	}

	// ע���˺���Ϣ
	private String Registr(String username, String password) {
		db1 = new DBHelper("myclient");// ����DBHelper����

		try {
			if ((db1.st.executeUpdate("insert into account values('" + username
					+ "', '" + password + "')")) == 1) { // ע��ɹ�

				db1.st.executeUpdate("create table " + username
						+ "friends (name varchar(16) not null, age int null, state vachar(6) null)");
				return "OK";
			}
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "NO";
	}

}
