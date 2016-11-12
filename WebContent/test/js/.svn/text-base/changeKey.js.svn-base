var pass = {
	check_oldpass: function() {
		var oldpassword = $("#oldpass").val();
		var newpassword = $("#newpass").val();
		var newrepassword = $("#re-newpass").val();
		if(oldpassword === '') alert('请输入旧密码');
		else if(newpassword === '') alert('请输入新密码');
		else if(newrepassword === '') alert('请再次输入新密码');
		else if(newpassword != newrepassword) alert('重复密码与新密码不一致');
		else if(oldpassword == newrepassword) alert('新密码不能与原密码相同');
		else {
			$.ajax({
				type: "get",
				url: "http://192.168.16.20:3500/mobileModifypass/getUserpass?username=18600000001&oldpass=" + oldpassword,
				async: true,
				dataType: "json",
				success: function(data) {
					if(JSON.stringify(data.result) == '"fail"') alert(data.message);
					else if(JSON.stringify(data.result) == '"success"') {
						console.log(JSON.stringify(data));
						alert("密码修改成功,请重新登录");

						$.ajax({
							type: "get",
							url: "http://192.168.16.20:3500/mobileModifypass/doAdd?password=" + newrepassword,
							async: true,
							dataType: "json",
							success: function(data) {

							}
						});
						window.location.href = "login.html";
					} else if(JSON.stringify(data.result) == '"sessionfail"') {
						alert(data.message);
						window.location.href = "login.html";
					}
				}
			});
		}
	}
};
$(document).ready(function() {
	$("#changepass").click(function() {
		pass.check_oldpass();
	});

});