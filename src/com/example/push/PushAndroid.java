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
	public void PushMessageToAndroid(String sender, String receiver,
			String content) throws Exception {
		PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();
		androidRequest.setAppKey(HttpURL.appKey);
		androidRequest.setTarget("device");
		androidRequest.setTargetValue("2270d39f46b548c983b88cd150100ba9");
		androidRequest.setMessage(content);

		PushMessageToAndroidResponse androidResponse = client
				.getAcsResponse(androidRequest);
		System.out.printf("RequestId: %s, ResponseId: %s, message: %s\n",
				androidResponse.getRequestId(),
				androidResponse.getResponseId(), androidResponse.getMessage());
	}

	/**
	 * 向Android推送通知
	 */
	public void PushNoticeToAndroid(String sender, String receiver,
			String content) throws Exception {

		System.out.println("向Android推送通知");

		PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
		androidRequest.setAppKey(HttpURL.appKey); // AppKey信息
		androidRequest.setTarget("device"); // 推送目标
		androidRequest.setTargetValue("2270d39f46b548c983b88cd150100ba9"); // 根据Target来设定
		androidRequest.setTitle(sender); // 发送的通知标题
		androidRequest.setSummary(content); // 发送的通知内容

		// androidRequest.setTitle(sender); // 发送者
		// androidRequest.setTarget(receiver); // 接收者
		// androidRequest.setTarget(sender); // 接收者
		// androidRequest.setSummary(content); // 发送内容

		PushNoticeToAndroidResponse androidResponse = client
				.getAcsResponse(androidRequest);
		System.out.printf("RequestId: %s, ResponseId: %s, message: %s\n",
				androidResponse.getRequestId(),
				androidResponse.getResponseId(), androidResponse.getMessage());

	}

}
