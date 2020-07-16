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
				"没有，别再给我发邮件了，病毒阿里", "没有，别再给我发邮件了，病毒阿里");
		client = new DefaultAcsClient(profile);
		
	}

}
