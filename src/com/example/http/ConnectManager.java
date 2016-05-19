package com.example.http;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.database.DataBaseDemo;
import com.example.database.UpdateState;
import com.example.push.DeviceInfoDemoTest;
import com.example.push.PushAndroid;

/**
 * �ͻ�������״̬����
 * 
 * @author YY
 */
public class ConnectManager {
	private JSONObject jsonObject = new JSONObject();

	public ConnectManager() {
	}

	/**
	 * ת���ͻ���֮�����Ϣ
	 * 
	 * @param sender
	 *            ������
	 * @param receiver
	 *            ������
	 * @param content
	 *            ��Ϣ����
	 * @return String
	 */
	public String Notice(String sender, String receiver, String content) {
		String string = null;
		String DeviceId = new DataBaseDemo().QueryDeviceId(receiver); // ��ȡ�豸ID

		if (!DeviceId.equals("null") && !DeviceId.equals("")
				&& DeviceId != null) { // �豸ID�Ƿ����
			try {
				if (new DeviceInfoDemoTest().testGetDeviceInfos(DeviceId)) { // ��ID���߷�����Ϣ
					string = new PushAndroid().PushMessageToAndroid(sender,
							DeviceId, content); // ���߷�����Ϣ
				} else {
					string = new PushAndroid().PushNoticeToAndroid(sender,
							DeviceId, content); // ���߷�������
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else { // û���豸ID
			System.out.println(receiver+" �˺�δ��½");
		}

		if (!string.equals("") && string != null) {
			return "Ok";
		}

		return "No";
	}

	/**
	 * ע��
	 * 
	 * @param sender
	 *            ������
	 * @return String
	 */
	public String logout(String sender) {
		// onLogou(sender); // ע��ʱ��������״̬
		return new DataBaseDemo().addDeviceId(sender, "null");
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
			}
		} catch (JSONException e) {
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
