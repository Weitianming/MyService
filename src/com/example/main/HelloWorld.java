package com.example.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.database.DBHelper;
import com.example.database.DataBasePicture;
import com.example.http.ConnectManager;
import com.example.http.Server;

public class HelloWorld extends HttpServlet {
	String url = "192.168.1.106:8080";
	JSONArray jsonArray;
	JSONObject jsonObject;

	public HelloWorld() {
		System.out.println("HelloWorld");
		System.out.println("");
	}
	
	// Get请求
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get： " + request.getRequestURI().toString());
		
		response.getWriter().println("Hello, World!袁艺");
	
		 JSONObject jsonObject = new JSONObject();
		 Map map = request.getParameterMap();
		 Iterator<?> it = map.keySet().iterator();
		 while (it.hasNext()) {
		 String key = (String) it.next();
		 System.out.println("key " + key);
		 String[] value = (String[]) map.get(key);
		
		 try {
		 jsonObject.accumulate(key, value[0]);
		 } catch (JSONException e) {
		 e.printStackTrace();
		 }
		 }

		if (request.getRequestURI().toString()
				.equals("/MyServersText/HelloWorld")) {

			jsonArray = new DataBasePicture().PictureDB();

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;UTF-8");
			response.getWriter().println(jsonArray.toString());

		}
	}

	// Post请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 获取请求
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(req.getInputStream(), "UTF-8"));
		String line = "";
		StringBuilder builder = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			builder.append(line);
		}
		String reqBody = builder.toString();

		// 反馈请求
		jsonObject = new JsonParam().Param(reqBody, resp);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println("返回的信息" + jsonObject.toString());
		out.write(jsonObject.toString());

	}

	@Override
	public void init() throws ServletException {
		new ChatServer().start();
		System.out.println("init");
	}

	// @Override
	// public void destroy()
	// {
	// System.out.println("Servlet " + this.getServletName() + " has stopped.");
	// }
}
