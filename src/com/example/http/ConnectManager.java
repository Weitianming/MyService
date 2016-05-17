package com.example.http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.database.DataBaseDemo;
import com.example.database.UpdateState;
import com.example.push.DeviceInfoDemoTest;
import com.example.push.PushAndroid;

public class ConnectManager {
	private PrintWriter writer;
	private JSONObject jsonObject = new JSONObject();
	private Socket socket;

	public ConnectManager() {
	}

	// ������Ϣ
	public boolean send(String receiver, JSONObject jsonObject)
			throws IOException {
		if (HttpURL.map.get(receiver) != null) {
			socket = HttpURL.map.get(receiver);
			writer = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream(), "UTF-8"), true);
			writer.println(jsonObject.toString());
			writer.flush();
			return true;
		} else {
			return false;
		}
	}

	// ת���ͻ���֮�����Ϣ
	public String Notice(String sender, String receiver, String content) {

		String DeviceId = new DataBaseDemo().QueryDeviceId(receiver);
		DeviceId = "2270d39f46b548c983b88cd150100ba9";

		try {

			if (new DeviceInfoDemoTest().testGetDeviceInfos(DeviceId)) { // ��ID���߷�����Ϣ
				new PushAndroid().PushMessageToAndroid(sender, DeviceId,
						content);
			} else {
				new PushAndroid()
						.PushNoticeToAndroid(sender, DeviceId, content); // �����߷�������
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// JSONObject object = new JSONObject();
		// try {
		// object.put("sender", sender);
		// object.put("content", content);
		// jsonObject.put("object", "notice");
		// jsonObject.put("message", object);
		//
		// if (send(receiver, jsonObject)) {
		// return "Ok";
		// } else {
		// return "No";
		// }
		// } catch (JSONException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		return "No";
	}

	// ע��
	public String logout(String sender) {
		onLogou(sender); // ע��ʱ��������״̬
		if (HttpURL.map.get(sender) != null) {
			HttpURL.map.remove(sender);
			return "Ok";
		}
		return "No";
	}

	// ����֪ͨ
	public String onLogin(String sender) {
		String string = new UpdateState().FriendsState(sender);
		String[] NAMES = string.split("/");
		if (NAMES[0].equals("")) {
			NAMES = new String[0];
		}

		try {
			for (int i = 0; i < NAMES.length; i++) {
				jsonObject.put("object", "onLogin");
				jsonObject.put("sender", sender);
				send(NAMES[i], jsonObject);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "OK";
	}

	// ����֪ͨ
	public String onLogou(String sender) {
		// �޸ĸ��û������������е�״̬

		return null;
	}

}
