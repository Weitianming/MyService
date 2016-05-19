package com.example.main;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 反馈客户端的请求
 * @author YY
 */
public class Connect {
	JSONObject jsonObject = new JSONObject();

	/**
	 * 反馈登录信息
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
	 * 反馈注册信息
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
	 * 获取账号下的所有好友
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
	 * 反馈消息信息
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
	 * 反馈注销信息
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

	// 上线通知
	public JSONObject onLoginResponse(String Result) {
		try {
			jsonObject.put("onLogin", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	// 下线通知
	public JSONObject onLogoutResponse(String Result) {
		try {
			jsonObject.put("onLogout", Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
