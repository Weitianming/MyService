$('.Pull').pullToRefresh().on("pull-to-refresh", function() {
	setTimeout(function() {
		//		$("#time").text(new Date);
		$('.Pull').pullToRefreshDone();
	}, 1000);
});