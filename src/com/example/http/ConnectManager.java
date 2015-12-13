package com.example.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

public class ConnectManager {
	Socket socket;
	private PrintWriter writer;
	
	JSONObject jsonObject = new JSONObject();

	private DataOutputStream out;
	
	public ConnectManager() {
	}

	public ConnectManager(Socket socket) {

	}

	// ��ͻ��˷�����Ϣ
	public String Notice(String sender, String receiver, String content) {

		JSONObject object = new JSONObject();

		try {
			object.put("sender", sender);
			object.put("content", content);
			jsonObject.put("object", "notice");
			jsonObject.put("message", object);
			
			if (HttpURL.map.get(receiver) != null) {
				socket = HttpURL.map.get(receiver);
//				out = new DataOutputStream(socket.getOutputStream());
//				out.writeUTF(jsonObject.toString());
				writer = new PrintWriter(socket.getOutputStream());
				writer.println(jsonObject.toString());
				return "Ok";
			} else {
				return "No";
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "No";
	}

	// ע��
	public String logout(String sender) {
		// ���������û�����(�ͻ���)

		return null;
	}

	// ����֪ͨ
	public String onLogin(String sender) {
		// ���������û�����(�ͻ���)

		return null;
	}

	// ����֪ͨ
	public String onLogou(String sender) {
		// ���������û�����(�ͻ���)

		return null;
	}

}
