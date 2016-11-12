$(function() {
	FastClick.attach(document.body); // 去除手机端300毫秒延迟
});

var suggestion = {
	text_isNull: function() {
		var suggestions = $('.weui_textarea.suggestion').val();
		var url = '/mobileFeedback/doAdd?suggestion=' + suggestions;
		doGet(url, function(data) {
			if(suggestions != '') {
				$.alert("反馈成功", "通知", function() {
					window.location.href = "index.html#mine";
				});
			}
		});
	}
}
$(document).ready(function() {
	$('#suggestion').click(function() {
		suggestion.text_isNull()
	})
})