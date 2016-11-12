var serverIP = 'http://192.168.0.106:3500';

// get请求
function doGet(url, callback, param) {
	$.ajax({
		type: "get",
		url: serverIP + url,
		async: false,
		data: param,
		dataType: "json",
		success: function(data) {
			if(JSON.stringify(data.result) == '"success"') { // 判断是否会话超时
				callback(data);
			} else {
				$.alert(data.message, "通知", function() { // 会话超时重新登录
					window.location.href = "login.html";
				});
			}
		},
		error: function(data) {
			callback(data);
		}
	});
};

// 本地保存用户信息
var LOGINDATA = localStorage.getItem("login");
if(LOGINDATA != null) {
	JSON.parse(LOGINDATA);
} else {
	$.alert("请重新登录", "通知", function() { // 用户信息丢失须重新登录
		window.location.href = "login.html";
	});
}