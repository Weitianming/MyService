
			var psd = {
					forget_psd: function() {
						var Realname = $.trim($("#realname").val());
						var Phone = $.trim($("#phone").val());
						if(Realname === '') alert('请输入真实姓名');
						else if(Phone === '') alert('请输入手机号');
						else {
							$.ajax({
								type: "get",
								url: "http://127.0.0.1:3500/login/forgetPassword?",
								data: $(".form_psd").serialize(),
								async: true,
								dataType: "json",
								success: function(data) {
									console.log(JSON.stringify(data));
									if(data.message=='密码重置成功!')
							{
								window.location.href="index.html";
							}
							else if(JSON.stringify(data.result) == '"sessionfail"'){
								
								alert(data.message);
							}
								}
							});

						}
					},
					code: function() {
						var Phone = $.trim($("#phone").val());
						$.ajax({
								type: "get",
								url: "http://127.0.0.1:3500/login/doSendMessage?sendphone=" +Phone,
								async: true,
								dataType: "json",
								success: function(data) {
									console.log(JSON.stringify(data));
								}

						}) 

						}
					}

				
						$(document).ready(function() {
						$("#psd").on("click", function() {
							psd.forget_psd();

						})
						$("#code_btn").on("click", function() {
							psd.code();

						})
					})
