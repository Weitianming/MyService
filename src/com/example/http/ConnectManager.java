package com.example.http;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.database.DataBaseDemo;
import com.example.database.UpdateState;
import com.example.push.DeviceInfoDemoTest;
import com.example.push.PushAndroid;

/**
 * 客户端数据状态处理
 * 
 * @author YY
 */
public class ConnectManager {
	private JSONObject jsonObject = new JSONObject();

	public ConnectManager() {
	}

	/**
	 * 转发客户端之间的消息
	 * 
	 * @param sender
	 *            发送者
	 * @param receiver
	 *            接收者
	 * @param content
	 *            消息内容
	 * @return String
	 */
	public String Notice(String sender, String receiver, String content) {
		String string = null;
		String DeviceId = new DataBaseDemo().QueryDeviceId(receiver); // 获取设备ID

		if (!DeviceId.equals("null") && !DeviceId.equals("")
				&& DeviceId != null) { // 设备ID是否存在
			try {
				if (new DeviceInfoDemoTest().testGetDeviceInfos(DeviceId)) { // 该ID在线发送消息
					string = new PushAndroid().PushMessageToAndroid(sender,
							DeviceId, content); // 在线发送消息
				} else {
					string = new PushAndroid().PushNoticeToAndroid(sender,
							DeviceId, content); // 离线发送推送
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else { // 没有设备ID
			System.out.println(receiver+" 账号未登陆");
		}

		if (!string.equals("") && string != null) {
			return "Ok";
		}

		return "No";
	}

	/**
	 * 注销
	 * 
	 * @param sender
	 *            发送者
	 * @return String
	 */
	public String logout(String sender) {
		// onLogou(sender); // 注销时处于下线状态
		return new DataBaseDemo().addDeviceId(sender, "null");
	}
	
	
	
	
	
	

	// 上线通知
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

	// 下线通知
	public String onLogou(String sender) {
		// 修改该用户在其他好友中的状态

		return null;
	}

}
