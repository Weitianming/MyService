package com.example.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.example.push.BaseTest;

public class HelloWorld extends HttpServlet {
	JSONObject jsonObject;
	private String TOKEN = "asd123";
	
	private String appId = "wxc9027d13acfe5226";
	private String appSecret = "6e085d31e23252605ad94c6af22a1de8";
	private String access_token = "jCWbAsMIEiVqrzUEg7IRXthhVEPxEFLOuqJ3sCtIPxrfIrBCw3YRtnBbgLpdiy5vOs4kV1FtNbl2K2hSa2-ttAaMLhsMTRY2pOIMENeJFytrM9Ef3pwchRwh8pWerLouWMZjABAFVI";
	

//	public HelloWorld() {
//	}
	
	// Get����
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get�� " + request.getRequestURI().toString());
		
//		response.getWriter().println("Hello, World!");
//		response.getWriter().println("socket    " + socket + "     asd");
	
//		 JSONObject jsonObject = new JSONObject();
//		 Map map = request.getParameterMap();
//		 Iterator<?> it = map.keySet().iterator();
//		 while (it.hasNext()) {
//		 String key = (String) it.next();
//		 System.out.println("key " + key);
//		 String[] value = (String[]) map.get(key);
//		
//		 try {
//		 jsonObject.accumulate(key, value[0]);
//		 } catch (JSONException e) {
//		 e.printStackTrace();
//		 }
//		 
//		 }

//		if (request.getRequestURI().toString()
//				.equals("/MyServersText/HelloWorld")) {
//
//			jsonArray = new DataBasePicture().PictureDB();
//
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/json;UTF-8");
//			response.getWriter().println(jsonArray.toString());
//
//		}
		
		
		
		/**
		 * ΢��ƽ̨�ӿ�
		 */
		
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ����ַ���
		String echostr = request.getParameter("echostr");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		
		String[] str = {TOKEN, timestamp, nonce};
		Arrays.sort(str); // �ֵ�������
		String bigStr = str[0] + str[1] + str[2];
		
		// SHA1����
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
				
		// ȷ����������΢��
		if (digest.equals(signature)) {
			response.getWriter().print(echostr);
		} else {
			response.getWriter().println("Hello, World!");
		}
		
	}

	// Post����
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// ��ȡ����
		
		System.out.println("����  "+req.getInputStream());
		
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(req.getInputStream(), "UTF-8"));
		String line = "";
		StringBuilder builder = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			builder.append(line);
		}
		String reqBody = builder.toString();

		// ��������
		
		jsonObject = new JsonParam().Param(reqBody, resp);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		System.out.println("���ص���Ϣ" + jsonObject.toString());
		out.write(jsonObject.toString());
//		System.out.println("���ص���Ϣ" + "asdqwe");
//		out.write("asdqwe");

	}

	@Override
	public void init() throws ServletException {
		new ChatServer().start();
		System.out.println("init");
		
		try {
			new BaseTest().beforeClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// @Override
	// public void destroy()
	// {
	// System.out.println("Servlet " + this.getServletName() + " has stopped.");
	// }
}
