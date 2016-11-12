$(function() {
	vipspa.start({
		view: '#ui-view',
		router: {
			'task': {
				templateUrl: 'task/task.html',
				controller: 'task/task.js'
			},
			'administrator': {
				templateUrl: 'administrator/administrator.html',
				controller: 'administrator/administrator.js'
			},
			'mine': {
				templateUrl: 'mine/mine.html',
				controller: 'mine/mine.js'
			},
			'defaults': 'task' // 不符合上述路由时，默认跳至
		},
		errorTemplateId: '#error'
	});
});