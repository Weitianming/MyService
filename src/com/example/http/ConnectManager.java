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

	// 向客户端发生消息
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

	// 注销
	public String logout(String sender) {
		// 发生给该用户好友(客户端)

		return null;
	}

	// 上线通知
	public String onLogin(String sender) {
		// 发生给该用户好友(客户端)

		return null;
	}

	// 下线通知
	public String onLogou(String sender) {
		// 发生给该用户好友(客户端)

		return null;
	}

}
