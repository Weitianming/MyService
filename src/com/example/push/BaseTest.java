package com.example.push;

import org.junit.BeforeClass;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class BaseTest {
	protected static DefaultAcsClient client;

	@BeforeClass
	public static void beforeClass() throws Exception {
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",
				"KzuqnYKPlkUZb4PS", "EH91BgTQYavkawQNlhTw1in8S2X9jm");
		client = new DefaultAcsClient(profile);
		
	}

}
