package com.example.main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.http.HttpURL;

public class ChatServer extends Thread {
	private ServerSocket chatServerSocket;
	private Socket socket;
	private boolean isSocket = false;
	private DataInputStream in = null;
	private JSONObject jsonObject;

	@Override
	public void run() {

		try {
			chatServerSocket = new ServerSocket(5123);
			while (true) {
				System.out.println("等待连接！！");
				socket = chatServerSocket.accept();
				System.out.println("连接成功:"
						+ socket.getInetAddress().getHostAddress());
				isSocket = true;

				new InputStreamSocket(socket).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	class InputStreamSocket extends Thread {
		private Socket socket;
		public InputStreamSocket(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
			in = new DataInputStream(socket.getInputStream());

			while (isSocket) {
				String string = in.readUTF();
				jsonObject = new JSONObject(string);
				
				if (HttpURL.map.get("sender") != null) {
					HttpURL.map.remove(jsonObject.getString("sender"));
					HttpURL.map.put(jsonObject.getString("sender"), socket);
					isSocket = false;
				} else {
					HttpURL.map.put(jsonObject.getString("sender"), socket);
					isSocket = false;
				}
				System.out.println("接收端增加至" + HttpURL.map.size());

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
		}
		
	}


}
