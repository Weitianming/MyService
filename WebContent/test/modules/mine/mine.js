$(document).ready(function() {
	$(".weui_cell.aboutUs").click(function() {
		$("#123").popup();
	});
	$(".weui_cell.exit").click(function() {
		$.actions({
			title: ["确定要退出登录吗？"],
			actions: [{
				text: "退出登录",
				className: "color-danger",
				onClick: function() {
					window.location.href = "login.html";
				}
			}]
		});
	});

});


// 头像
//function changehead() {
	console.log('JS-SDK')
	wx.config({
		debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		appId: 'wxc9027d13acfe5226', // 必填，公众号的唯一标识
		timestamp: 7200, // 必填，生成签名的时间戳
		nonceStr: 'asd123', // 必填，生成签名的随机串
		signature: '36737dda9e8a4c2d3b99c35dcefa304e9fc77215', // 必填，签名，见附录1
		jsApiList: [
				'checkJsApi',
				'onMenuShareTimeline',
				'onMenuShareAppMessage',
				'onMenuShareQQ',
				'onMenuShareWeibo',
				'hideMenuItems',
				'showMenuItems',
				'hideAllNonBaseMenuItem',
				'showAllNonBaseMenuItem',
				'translateVoice',
				'startRecord',
				'stopRecord',
				'onRecordEnd',
				'playVoice',
				'pauseVoice',
				'stopVoice',
				'uploadVoice',
				'downloadVoice',
				'chooseImage',
//				'previewImage',
//				'uploadImage',
//				'downloadImage',
//				'getNetworkType',
//				'openLocation',
//				'getLocation',
//				'hideOptionMenu',
//				'showOptionMenu',
//				'closeWindow',
//				'scanQRCode',
//				'chooseWXPay',
//				'openProductSpecificView',
//				'addCard',
//				'chooseCard',
//				'openCard'
			] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});

//var param = {asd:'asd'};
//	$.ajax({
//		type: "post",
//		url: "127.0.0.1:3600",
//		async: false,
//		data: param,
//		dataType: "json",
//		success: function(data) {
//				console.log('data  '+data)
//		},
//		error: function(data) {
//			console.log('err  '+JSON.stringify(data))
//		}
//	});



//}