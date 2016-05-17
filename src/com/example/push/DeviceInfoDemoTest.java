package com.example.push;

import java.util.List;

import org.junit.Test;

import com.aliyuncs.push.model.v20150827.GetDeviceInfosRequest;
import com.aliyuncs.push.model.v20150827.GetDeviceInfosResponse;
import com.aliyuncs.push.model.v20150827.GetDeviceInfosResponse.DeviceInfo;
import com.example.http.HttpURL;

/**
 * 查询设备在线状态
 * 
 * @author YY
 */
public class DeviceInfoDemoTest extends BaseTest {

	/**
	 * 查询单个设备在线状态
	 * 
	 * @param DeviceID
	 *            查询的设备ID
	 * @throws Exception
	 */
	@Test
	public boolean testGetDeviceInfos(String DeviceID) throws Exception {
		GetDeviceInfosRequest getDeviceInfosRequest = new GetDeviceInfosRequest();
		getDeviceInfosRequest.setAppKey(HttpURL.appKey);
		getDeviceInfosRequest.setDevices(DeviceID);

		GetDeviceInfosResponse getDeviceInfosResponse = client
				.getAcsResponse(getDeviceInfosRequest);

		List<DeviceInfo> deviceInfo = getDeviceInfosResponse.getDeviceInfos();

		return deviceInfo.get(0).getIsOnline();
	}

}
