package com.example.main;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * �����ͻ��˵�����
 * @author YY
 */
public class Connect {
	JSONObject jsonObject = new JSONObject();

	/**
	 * ������¼��Ϣ
	 * @param Result
	 * @return
	 */
	public JSONObject LoginResponse(String Result) {
		try {
			jsonObject.put("LoginResponse", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * ����ע����Ϣ
	 * @param Result
	 * @return
	 */
	public JSONObject RegisterResponse(String Result) {
		try {
			jsonObject.put("RegisterResponse", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * ��ȡ�˺��µ����к���
	 * @param Result
	 * @return
	 */
	public JSONObject getAllUsersName(String Result) {
		JSONObject Object = new JSONObject();
		try {
			Object.put("content", Result);
			jsonObject.put("object", "getAllUsersName");
			jsonObject.put("message", Object);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * ������Ϣ��Ϣ
	 * @param Result
	 * @return
	 */
	public JSONObject NoticeResponse(String Result) {
		try {
			jsonObject.put("NoticeResponse", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * ����ע����Ϣ
	 * @param Result
	 * @return
	 */
	public JSONObject LogoutResponse(String Result) {
		try {
			jsonObject.put("LogoutResponse", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	// ����֪ͨ
	public JSONObject onLoginResponse(String Result) {
		try {
			jsonObject.put("onLogin", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	// ����֪ͨ
	public JSONObject onLogoutResponse(String Result) {
		try {
			jsonObject.put("onLogout", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
