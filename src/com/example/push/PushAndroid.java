package com.example.push;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.push.model.v20150827.PushMessageToAndroidRequest;
import com.aliyuncs.push.model.v20150827.PushMessageToAndroidResponse;
import com.aliyuncs.push.model.v20150827.PushNoticeToAndroidRequest;
import com.aliyuncs.push.model.v20150827.PushNoticeToAndroidResponse;

public class PushAndroid {
	long appKey = 23343518;

	/**
	 * 向Android推送消息
	 */
	public void PushMessageToAndroid() {
		PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();

		PushMessageToAndroidResponse androidResponse;

	}

	/**
	 * 向Android推送通知
	 */
	public void PushNoticeToAndroid(String sender, String receiver, String content) throws Exception {
		
		
		
		DefaultAcsClient client = new DefaultAcsClient();
		PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        androidRequest.setAppKey(appKey);
        androidRequest.setTitle(sender); // 发送者
		androidRequest.setTarget(receiver); // 接收者
        androidRequest.setSummary(content); // 发送内容
		
		PushNoticeToAndroidResponse androidResponse = client.getAcsResponse(androidRequest);

	}

}
