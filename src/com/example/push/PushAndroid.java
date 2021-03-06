package com.example.push;

import com.aliyuncs.push.model.v20150827.PushMessageToAndroidRequest;
import com.aliyuncs.push.model.v20150827.PushMessageToAndroidResponse;
import com.aliyuncs.push.model.v20150827.PushNoticeToAndroidRequest;
import com.aliyuncs.push.model.v20150827.PushNoticeToAndroidResponse;
import com.example.http.HttpURL;

public class PushAndroid extends BaseTest {

	/**
	 * 向Android推送消息
	 */
	public String PushMessageToAndroid(String sender, String receiver,
			String content) throws Exception {
		System.out.println("向Android推送消息");
		
		PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();
		androidRequest.setAppKey(HttpURL.appKey); // AppKey信息
		androidRequest.setTarget("device"); // 推送目标
		androidRequest.setTargetValue(receiver); // 根据Target来设定
		androidRequest.setMessage(sender+"/"+content); // 发送的消息内容

		PushMessageToAndroidResponse androidResponse = client
				.getAcsResponse(androidRequest);
		System.out.printf("RequestId: %s, ResponseId: %s, message: %s\n",
				androidResponse.getRequestId(),
				androidResponse.getResponseId(), androidResponse.getMessage());
		return androidResponse.getResponseId();
	}

	/**
	 * 向Android推送通知
	 */
	public String PushNoticeToAndroid(String sender, String receiver,
			String content) throws Exception {

		System.out.println("向Android推送通知");

		PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
		androidRequest.setAppKey(HttpURL.appKey); // AppKey信息
		androidRequest.setTarget("device"); // 推送目标
		androidRequest.setTargetValue(receiver); // 根据Target来设定
		androidRequest.setTitle(sender); // 发送的通知标题
		androidRequest.setSummary(content); // 发送的通知内容

		PushNoticeToAndroidResponse androidResponse = client
				.getAcsResponse(androidRequest);
		System.out.printf("RequestId: %s, ResponseId: %s, message: %s\n",
				androidResponse.getRequestId(),
				androidResponse.getResponseId(), androidResponse.getMessage());
		return androidResponse.getResponseId();

	}

}
